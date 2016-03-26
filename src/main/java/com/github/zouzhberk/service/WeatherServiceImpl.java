package com.github.zouzhberk.service;

import com.github.zouzhberk.configuration.HeWeatherConfig;
import com.github.zouzhberk.essence.rxweather.RxWeather;
import com.github.zouzhberk.essence.rxweather.domain.Cities;
import com.github.zouzhberk.essence.rxweather.domain.CityWeatherEntity;
import com.github.zouzhberk.essence.rxweather.features.WeatherApi;
import com.github.zouzhberk.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by berk on 3/23/16.
 */
@Service
public class WeatherServiceImpl {


    private WeatherApi weatherApi;

    @Autowired
    private HeWeatherConfig heWeatherConfig;

    private List<Cities.CityInfoEntity> citylist;

    public WeatherServiceImpl() {
        System.out.println(heWeatherConfig);

    }

    public WeatherApi getWeatherApi() {
        System.out.println(heWeatherConfig);
        if (weatherApi == null) {
            weatherApi = RxWeather.Builder.baseUrl(heWeatherConfig.getBaseurl())
                    .build()
                    .create(WeatherApi.class);

        }
        return weatherApi;
    }

    public String getWeatherInfo(String inputName, String key) {

        String cityName = inputName.replace("W", "")
                .replace("天气", "");
        return getWeatherApi().getCityWeather(cityName, key)
                .toBlocking()
                .first()
                .values()
                .stream()
                .findFirst()
                .map(Stream::of)
                .orElseGet(Stream::empty)
                .peek(x -> System.out.println(JsonUtils.toJson(x)))
                .map(x -> to7DForcastString(x))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse("找不到" + cityName +
                        "天气情况");

    }

    public String getWeatherInfo(String cityName) {
        return getWeatherInfo(cityName, heWeatherConfig.getKey());
    }

    public static final DateTimeFormatter ISO_LOCAL_DATE;

    static {
        ISO_LOCAL_DATE = new DateTimeFormatterBuilder()

                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral("日")
                .appendText(ChronoField.DAY_OF_WEEK)
                .toFormatter(Locale.CHINA);
    }

    public static String toChinaDate(String date) {
        return LocalDate.parse(date).format(ISO_LOCAL_DATE);
    }

    private static String toDailyForcastString(CityWeatherEntity
                                                       .DailyForecastEntity
                                                       entity) {
        return String.format(Locale.CHINA, "%s, 温度(%s , %s), 白天%s, 晚上%s",
                toChinaDate(entity
                        .getDate()), entity.getTmp().getMin(), entity.getTmp()
                        .getMax(), entity.getCond()
                        .getTxtDay(), entity.getCond().getTxtNight());
    }

    private static String to7DForcastString(CityWeatherEntity
                                                    .WeatherDataEntity entity) {

        System.out.println(JsonUtils.toJson(entity));
        if (entity == null || entity.getBasic() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getBasic().getCity());
        sb.append(" 未来天气如下：\n")
                .append(entity.getDailyForecast()
                        .stream()
                        .map(x -> toDailyForcastString(x))
                        .collect(Collectors.joining("\n")));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.parse("2016-03-23")
                .format(ISO_LOCAL_DATE)
                .toString());
    }

    public Optional<String> findCityIdByName(String cityName) {
        if (citylist == null) {
            citylist = getWeatherApi().listCityInfo("allchina", heWeatherConfig
                    .getKey())
                    .map(x -> x.getCityInfo())
                    .toBlocking()
                    .first();
        }
        return citylist.stream()
                .filter(x -> cityName.contains(x.getCity()))
                .map(x -> x.getId())
                .findFirst();
    }


}
