package com.github.zouzhberk.essence.rxweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;


/**
 * Created by berk on 3/23/16.
 */
public class CityWeatherEntity extends HashMap<String, CityWeatherEntity
        .WeatherDataEntity[]>
{

    public static class WeatherDataEntity
    {


        public Object getAqi()
        {
            return aqi;
        }

        public void setAqi(Object aqi)
        {
            this.aqi = aqi;
        }

        private Object aqi;
        /**
         * city : 南子岛
         * cnty : 中国
         * id : CN101310230
         * lat : 11.26
         * lon : 114.20
         * update : {"loc":"2016-03-23 23:02","utc":"2016-03-23 15:02"}
         */

        private BasicEntity basic;
        /**
         * cond : {"code":"103","txt":"晴间多云"}
         * fl : 35
         * hum : 77
         * pcpn : 0.0
         * pres : 1012
         * tmp : 29
         * vis : 10
         * wind : {"deg":"83","dir":"东风","sc":"微风","spd":"12"}
         */

        private NowWeatherEntity now;
        private String status;
        /**
         * astro : {"sr":"06:24","ss":"18:33"}
         * cond : {"code_d":"103","code_n":"101","txt_d":"晴间多云","txt_n":"多云"}
         * date : 2016-03-23
         * hum : 81
         * pcpn : 0.0
         * pop : 0
         * pres : 1011
         * tmp : {"max":"32","min":"28"}
         * vis : 10
         * wind : {"deg":"83","dir":"东风","sc":"微风","spd":"3"}
         */
        @JsonProperty("daily_forecast")
        private List<DailyForecastEntity> dailyForecast;

        public Object getHourlyForecast()
        {
            return hourlyForecast;
        }

        public void setHourlyForecast(Object hourlyForecast)
        {
            this.hourlyForecast = hourlyForecast;
        }

        @JsonProperty("hourly_forecast")
        private Object hourlyForecast;

        @JsonProperty("suggestion")
        private Object suggestion;
//        @JsonProperty("hourly_forecast")
//        private List<DailyForecastEntity> hourlyForecast;

        public BasicEntity getBasic()
        {
            return basic;
        }

        public void setBasic(BasicEntity basic)
        {
            this.basic = basic;
        }

        public NowWeatherEntity getNow()
        {
            return now;
        }

        public void setNow(NowWeatherEntity now)
        {
            this.now = now;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public List<DailyForecastEntity> getDailyForecast()
        {
            return dailyForecast;
        }

        public void setDailyForecast(List<DailyForecastEntity> dailyForecast)
        {
            this.dailyForecast = dailyForecast;
        }


        public static class BasicEntity
        {
            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            /**
             * loc : 2016-03-23 23:02
             * utc : 2016-03-23 15:02
             */

            private UpdateEntity update;

            public String getCity()
            {
                return city;
            }

            public void setCity(String city)
            {
                this.city = city;
            }

            public String getCnty()
            {
                return cnty;
            }

            public void setCnty(String cnty)
            {
                this.cnty = cnty;
            }

            public String getId()
            {
                return id;
            }

            public void setId(String id)
            {
                this.id = id;
            }

            public String getLat()
            {
                return lat;
            }

            public void setLat(String lat)
            {
                this.lat = lat;
            }

            public String getLon()
            {
                return lon;
            }

            public void setLon(String lon)
            {
                this.lon = lon;
            }

            public UpdateEntity getUpdate()
            {
                return update;
            }

            public void setUpdate(UpdateEntity update)
            {
                this.update = update;
            }

            public static class UpdateEntity
            {
                private String loc;
                private String utc;

                public String getLoc()
                {
                    return loc;
                }

                public void setLoc(String loc)
                {
                    this.loc = loc;
                }

                public String getUtc()
                {
                    return utc;
                }

                public void setUtc(String utc)
                {
                    this.utc = utc;
                }
            }
        }


    }

    public static class NowWeatherEntity
    {
        /**
         * code : 103
         * txt : 晴间多云
         */

        private CondEntity cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        /**
         * deg : 83
         * dir : 东风
         * sc : 微风
         * spd : 12
         */

        private WindEntity wind;

        public CondEntity getCond()
        {
            return cond;
        }

        public void setCond(CondEntity cond)
        {
            this.cond = cond;
        }

        public String getFl()
        {
            return fl;
        }

        public void setFl(String fl)
        {
            this.fl = fl;
        }

        public String getHum()
        {
            return hum;
        }

        public void setHum(String hum)
        {
            this.hum = hum;
        }

        public String getPcpn()
        {
            return pcpn;
        }

        public void setPcpn(String pcpn)
        {
            this.pcpn = pcpn;
        }

        public String getPres()
        {
            return pres;
        }

        public void setPres(String pres)
        {
            this.pres = pres;
        }

        public String getTmp()
        {
            return tmp;
        }

        public void setTmp(String tmp)
        {
            this.tmp = tmp;
        }

        public String getVis()
        {
            return vis;
        }

        public void setVis(String vis)
        {
            this.vis = vis;
        }

        public WindEntity getWind()
        {
            return wind;
        }

        public void setWind(WindEntity wind)
        {
            this.wind = wind;
        }

        public static class CondEntity
        {
            private String code;
            private String txt;

            public String getCode()
            {
                return code;
            }

            public void setCode(String code)
            {
                this.code = code;
            }

            public String getTxt()
            {
                return txt;
            }

            public void setTxt(String txt)
            {
                this.txt = txt;
            }
        }


    }

    public static class DailyForecastEntity
    {
        /**
         * sr : 06:24
         * ss : 18:33
         */

        private AstroEntity astro;
        /**
         * code_d : 103
         * code_n : 101
         * txt_d : 晴间多云
         * txt_n : 多云
         */

        private CondEntity cond;
        private String date;
        private String hum;
        private String pcpn;
        private String pop;
        private String pres;
        /**
         * max : 32
         * min : 28
         */

        private TmpEntity tmp;
        private String vis;
        private WindEntity wind;

        public AstroEntity getAstro()
        {
            return astro;
        }

        public void setAstro(AstroEntity astro)
        {
            this.astro = astro;
        }

        public CondEntity getCond()
        {
            return cond;
        }

        public void setCond(CondEntity cond)
        {
            this.cond = cond;
        }

        public String getDate()
        {
            return date;
        }

        public void setDate(String date)
        {
            this.date = date;
        }

        public String getHum()
        {
            return hum;
        }

        public void setHum(String hum)
        {
            this.hum = hum;
        }

        public String getPcpn()
        {
            return pcpn;
        }

        public void setPcpn(String pcpn)
        {
            this.pcpn = pcpn;
        }

        public String getPop()
        {
            return pop;
        }

        public void setPop(String pop)
        {
            this.pop = pop;
        }

        public String getPres()
        {
            return pres;
        }

        public void setPres(String pres)
        {
            this.pres = pres;
        }

        public TmpEntity getTmp()
        {
            return tmp;
        }

        public void setTmp(TmpEntity tmp)
        {
            this.tmp = tmp;
        }

        public String getVis()
        {
            return vis;
        }

        public void setVis(String vis)
        {
            this.vis = vis;
        }

        public WindEntity getWind()
        {
            return wind;
        }

        public void setWind(WindEntity wind)
        {
            this.wind = wind;
        }

        public static class AstroEntity
        {
            private String sr;
            private String ss;

            public String getSr()
            {
                return sr;
            }

            public void setSr(String sr)
            {
                this.sr = sr;
            }

            public String getSs()
            {
                return ss;
            }

            public void setSs(String ss)
            {
                this.ss = ss;
            }
        }

        public static class CondEntity
        {

            @JsonProperty("code_d")
            private String codeDay;
            @JsonProperty("code_n")
            private String codeNight;
            @JsonProperty("txt_d")
            private String txtDay;

            @JsonProperty("txt_n")
            private String txtNight;

            public String getCodeDay()
            {
                return codeDay;
            }

            public void setCodeDay(String codeDay)
            {
                this.codeDay = codeDay;
            }

            public String getCodeNight()
            {
                return codeNight;
            }

            public void setCodeNight(String codeNight)
            {
                this.codeNight = codeNight;
            }

            public String getTxtDay()
            {
                return txtDay;
            }

            public void setTxtDay(String txtd)
            {
                this.txtDay = txtd;
            }

            public String getTxtNight()
            {
                return txtNight;
            }

            public void setTxtNight(String txtNight)
            {
                this.txtNight = txtNight;
            }
        }

        public static class TmpEntity
        {
            private String max;
            private String min;

            public String getMax()
            {
                return max;
            }

            public void setMax(String max)
            {
                this.max = max;
            }

            public String getMin()
            {
                return min;
            }

            public void setMin(String min)
            {
                this.min = min;
            }
        }
    }

    public static class WindEntity
    {
        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg()
        {
            return deg;
        }

        public void setDeg(String deg)
        {
            this.deg = deg;
        }

        public String getDir()
        {
            return dir;
        }

        public void setDir(String dir)
        {
            this.dir = dir;
        }

        public String getSc()
        {
            return sc;
        }

        public void setSc(String sc)
        {
            this.sc = sc;
        }

        public String getSpd()
        {
            return spd;
        }

        public void setSpd(String spd)
        {
            this.spd = spd;
        }
    }
}
