/**
 * @author:by@Deng
 * @timer:2016-12-07
 * @email:by@6886432@163.com
 * @version:1.0
 * @title:js的常用工具类
 */
'use strict'


export default{

    //*****************************************url工具类*****************************************
    UrlUtils:{
        /**
         * 需要追加的url
         */
        urlAppend:null,
        /**
         * 向url后追加key/value值
         * url不传的话默认为当前url
         * key
         * @return {[type]}           [description]
         */
        urlAddParamter(key,value,url){
            if(url){
                urlAppend = url;
            }
            if(!urlAppend){
                urlAppend = this.currentUrl();
            }
            urlAppend +=''+ (urlAppend.indexOf("?")==-1?"?":"&");
            urlAppend += encodeURIComponent(key)+'='+encodeURIComponent(value);
            return this;
        },
        /**
         * 获取追加字符串的url
         */
        getUrlAdd(){
            return urlAppend;
        },
        /**
         * 获取解码后的url(不包括#hash后的值)
         * @return {[type]} [description]
         */
        currentUrl(){
            return decodeURIComponent(window.location.href);
        },
        /**
         * 根据url的?后参数转为对象键值对
         * @return {[type]} [空]
         */
        getUrlParamObject() {
            var urlParam = decodeURIComponent(location.search);
            var param = {};
            if (urlParam.indexOf("?") != -1) {
                var arrStr = urlParam.substr(1).split("&");
                for (var i = 0; i < arrStr.length; i++) {
                    param[arrStr[i].split("=")[0]] = arrStr[i].split("=")[1];
                }
            }
            return param;
        }
    },


    //*********************************cookie或者locaStorage工具类*********************************
    CookieUtils:{
        /**
         * 判断cookie是否禁用
         * @return true未禁用，false已禁用
         */
        cookieEnabled(){
            return navigator.cookieEnabled;
        },
        /**
         * 设置cookie,time为保存时间，单位为s
         * time可传可不传
         * @param {[type]} key   [建议非中文]
         * @param {[type]} value [description]
         * @param {[type]} time  [description]
         */
        setCookie(key,value,time){
            if(time){
                document.cookie=key+'='+encodeURI(value)+";expires="+time;
            }else{
                document.cookie=key+'='+encodeURI(value);
            }
        },
        /**
         * 根据key获取cookie值，没有返回undefined
         * @param  {[type]} key [description]
         * @return {[type]}     [description]
         */
        getCookie(key) {
            var arr = document.cookie.split('; ');
            for(var i = 0; i < arr.length; i++) {
                var arrName = arr[i].split('=');
                if(arrName[0] == key) {
                    return decodeURI(arrName[1]);
                }
            }
            return;
        },
        /**
         * 删除cookie
         * @param  {[type]} key [description]
         * @return {[type]}     [description]
         */
        deleteCookie(key){
            var oDate=new Date();
            oDate.setDate(oDate.getDate()-1);
            document.cookie=key+"=1; expires="+ oDate;
        },
        /**
         * 设置localStorage存储，value都是字符串
         * @param {[type]} key   [description]
         * @param {[type]} value [数据较多时为json方便]
         */
        setLocalStorage(key,value){
            localStorage.setItem(key, value);
        },
        /**
         * 获取localStorage的值
         * @param  {[type]} key [description]
         * @return {[type]}     [description]
         */
        getLocalStorage(key){
            return localStorage.getItem(key);
        },
        /**
         * 删除某个localStorage的值
         * @param  {[type]} key [description]
         * @return {[type]}     [description]
         */
        deleteLocalStorage(key){
            localStorage.removeItem(key);
        },
        /**
         * 设置sessionStorage存储
         * @param {[type]} key   [description]
         * @param {[type]} value [description]
         */
        setSessionStorage(key,value){
            sessionStorage.setItem(key, value);
        },
        /**
         * 获取sessionStorage的存储值
         * @param  {[type]} key   [description]
         * @return {[type]}       [description]
         */
        getSessionStorage(key){
            return sessionStorage.getItem(key);
        },
        /**
         * 删除某个sessionStorage的值
         * @param  {[type]} key [description]
         * @return {[type]}     [description]
         */
        deleteSessionStorage(key){
            sessionStorage.removeItem(key);
        }
    },

    //**************************************对数字处理的num工具类************************************
    NumUtils:{
        /**
        * 一位数转为两位数或者三位数
        * @param  {[type]} num [数字]
        * @param  {[type]} bit [2/3,表明转为2位数或者3位数]
        * @return {[type]}     [description]
        */
        oneToTwoOrThree(num,bit){
            if(bit==2){
                if(num<10){
                    num='0'+num;
                }
            }else if(bit==3){
                if(num<10){
                    num='00'+num;
                }else if(num <100){
                    num = "0"+num;
                }
            }
            return num;
        },
        /**
         * 获取指定位数的随机整数
         * @return {[type]}       [description]
         */
        getRandomNum(count){
            var arr = new Array;
            var reNum = "";
            for(var i=0;i<count;i++){
                arr[i] = parseInt(Math.random()*10);
                reNum += String(arr[i]);
            }
            return reNum;
        }
    },

    //**************************************时间日期date的工具类************************************
    /**
     * 以下date1均默认小于date2
     */
    DateUtils:{
        time(){
            return {
                hour: 24,
                second: 60,
                mills: 3600,
                format: "yyyy-MM-dd",
                dateFormat: "yyyy-MM-dd HH:mm:ss"
            };
        },
        /**
        * 将日期格式化成指定格式的字符串
        * @param date 要格式化的日期，不传时默认当前时间，也可以是一个时间戳
        * @param fmt 目标字符串格式，支持的字符有：y,M,d,q,w,H,h,m,S，默认：yyyy-MM-dd HH:mm:ss
        * @returns 返回格式化后的日期字符串
        */
        formatDate(date, fmt){
            date = date == undefined ? new Date() : date;
            date = typeof date == 'number' ? new Date(date) : date;
            fmt = fmt || 'yyyy-MM-dd HH:mm:ss';
            var obj ={
                'y': date.getFullYear(), // 年份，注意必须用getFullYear
                'M': date.getMonth() + 1, // 月份，注意是从0-11
                'd': date.getDate(), // 日期
                'q': Math.floor((date.getMonth() + 3) / 3), // 季度
                'w': date.getDay(), // 星期，注意是0-6
                'H': date.getHours(), // 24小时制
                'h': date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, // 12小时制
                'm': date.getMinutes(), // 分钟
                's': date.getSeconds(), // 秒
                'S': date.getMilliseconds() // 毫秒
            };
            var week = ['日', '一', '二', '三', '四', '五', '六'];
            for(var i in obj){
                fmt = fmt.replace(new RegExp(i+'+', 'g'), function(m){
                    var val = obj[i] + '';
                    if(i == 'w') return (m.length > 2 ? '星期' : '周') + week[val];
                    for(var j = 0, len = val.length; j < m.length - len; j++) val = '0' + val;
                    return m.length == 1 ? val : val.substring(val.length - m.length);
                });
            }
            return fmt;
        },
        /**
        * 将字符串解析成日期
        * @param str 输入的日期字符串，如'2014-09-13'
        * @param fmt 字符串格式，默认'yyyy-MM-dd'，支持如下：y、M、d、H、m、s、S，不支持w和q
        * @returns 解析后的Date类型日期
        */
        parseDate(str, fmt){
            fmt = fmt || 'yyyy-MM-dd';
            var obj = {y: 0, M: 1, d: 0, H: 0, h: 0, m: 0, s: 0, S: 0};
            fmt.replace(/([^yMdHmsS]*?)(([yMdHmsS])\3*)([^yMdHmsS]*?)/g, function(m, $1, $2, $3, $4, idx, old){
                str = str.replace(new RegExp($1+'(\\d{'+$2.length+'})'+$4), function(_m, _$1){
                    obj[$3] = parseInt(_$1);
                    return '';
                });
                return '';
            });
            obj.M--; // 月份是从0开始的，所以要减去1
            var date = new Date(obj.y, obj.M, obj.d, obj.H, obj.m, obj.s);
            if(obj.S !== 0) date.setMilliseconds(obj.S); // 如果设置了毫秒
            return date;
        },
        /**
         * 日期转换
         * @param  {[type]} date [description]
         */
        transferDate(date) {
            if(typeof date == "string") {
                return new Date(date.replace(/-/ig, "/"));
            } else {
                return date;
            }
        },
        /**
         * 返回当前的时间戳
         * @return {[type]}      [description]
         */
        getTime(date) {
            return this.transferDate(date).getTime();
        },
        /**
         * 间隔毫秒
         * @return {[type]}       [description]
         */
        numMillSecond(date1, date2) {
            var stimes = this.getTime(this.transferDate(date1));
            var etimes = this.getTime(this.transferDate(date2));
            return etimes - stimes;
        },
        /**
         * 间隔秒
         * @return {[type]}       [description]
         */
        numSecond(date1,date2) {
            return Math.floor(this.numMillSecond(date1,date2) / 1000);
        },
        /**
         * 间隔分
         * @return {[type]}       [description]
         */
        numMinute(date1,date2) {
            return Math.floor(this.numMillSecond(date1, date2) / (1000 * 60));
        },
        /**
         * 间隔小时
         * @return {[type]}       [description]
         */
        numHour(date1, date2) {
            return Math.floor(this.numMillSecond(date1, date2) / (1000 * 60 * 60));
        },
        /**
         * 间隔天数
         * @return {[type]}       [description]
         */
        numDay(date1, date2) {
            var times = this.numSecond(date1, date2);
            var hour = this.time().hour;
            var mills = this.time().mills;
            return Math.ceil(times / (mills * hour));
        },
        /**
         * 间隔月份
         * @return {[type]}       [description]
         */
        numMonth(date1, date2) {
            var times = this.numDay(date1, date2);
            return Math.floor(times / 30);
        },
        /**
         * 间隔年份
         * @return {[type]}       [description]
         */
        numYear(date1, date2) {
            var times = this.numDay(date1, date2);
            return Math.floor(times / 365);
        },
        /**
         * 某个日期加上毫秒数
         * @return {[type]}               [description]
         */
        plusMillisSeconds(date,millisSeconds) {
            var dateTime = this.getTime(date);
            var mintimes = millisSeconds;
            var rdate = dateTime * 1 + mintimes * 1;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期加上秒数
         * @return {[type]}         [description]
         */
        plusSeconds(date,seconds) {
            var dateTime = this.getTime(date);
            var mintimes = seconds * 1000;
            var rdate = dateTime * 1 + mintimes * 1;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期加上分钟
         * @return {[type]}         [description]
         */
        plusMinutes(date,minutes){
            var dateTime = this.getTime(date);
            var mintimes = minutes * 60 * 1000;
            var rdate = dateTime * 1 + mintimes * 1;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期加上小时
         * @return {[type]}       [description]
         */
        plusHours(date,hours) {
            var dateTime = this.getTime(date);
            var mintimes = hours * 60 * 60 * 1000;
            var rdate = dateTime + mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /*某个日期加上天数*/
        plusDays(date,days){
            var dateTime = this.getTime(date);
            var mintimes = days * 60 * 60 * 1000 * 24;
            var rdate = dateTime * 1 + mintimes * 1;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期加上多少个月
         */
        plusMonths(date,months) {
            var dateTime = this.getTime(date);
            var dateStrTime = this.formatDate(new Date(dateTime),this.time.dateFormat);
            var dateDay = parseInt(dateStrTime.split("-")[1]);
            var year = parseInt(dateStrTime.split("-")[0]) + parseInt((months+dateDay)/13);
            dateDay += months;
            while(dateDay>12){
                dateDay -=12;
            }
            var dateDay1 = NumUtils.oneToTwoOrThree(dateDay,2);
            return year+'-'+dateDay1+dateStrTime.substr(7,dateStrTime.length-1);
        },
        /**
         * 某个日期加上多少年
         */
        plusYears(date,years) {
            var dateTime = this.getTime(date);
            var yearStrTime = this.formatDate(new Date(dateTime),this.time.dateFormat);
            var year = parseInt(yearStrTime.split("-")[0]) + years;
            return year +yearStrTime.substr(4,yearStrTime.length-1);
        },
        /**
         * 某个日期减去多少毫秒
         * @return {[type]}               [description]
         */
        minusMillisSeconds(date,millisSeconds) {
            var dateTime = this.getTime(date);
            var mintimes = millisSeconds * 1;
            var rdate = dateTime - mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期减去多少秒
         * @return {[type]}         [description]
         */
        minusSeconds(date,seconds) {
            var dateTime = this.getTime(date);
            var mintimes = seconds * 1000;
            var rdate = dateTime - mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期减去多少分钟
         * @return {[type]}         [description]
         */
        minusMinutes(date,minutes){
            var dateTime = this.getTime(date);
            var mintimes = minutes * 60 * 1000;
            var rdate = dateTime - mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期减去小时数
         * @return {[type]}       [description]
         */
        minusHours(date,hours){
            var dateTime = this.getTime(date);
            var mintimes = hours * 60 * 60 * 1000;
            var rdate = dateTime - mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期减去天数
         * @return {[type]}      [description]
         */
        minusDays(date, days) {
            var dateTime = this.getTime(date);
            var mintimes = days * 60 * 60 * 1000 * 24;
            var rdate = dateTime - mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期减去天数
         * @return {[type]}      [description]
         */
        minusDays(date, days) {
            var dateTime = this.getTime(date);
            var mintimes = days * 60 * 60 * 1000 * 24;
            var rdate = dateTime - mintimes;
            return this.formatDate(new Date(rdate),this.time.dateFormat);
        },
        /**
         * 某个日期减去多少个月
         * @return {[type]}        [description]
         */
        minusMonths(date, months) {
            var dateTime = this.getTime(date);
            var dateStrTime = this.formatDate(new Date(dateTime),this.time.dateFormat);
            var year =  parseInt(dateStrTime.split("-")[0]);
            var dateDay = parseInt(dateStrTime.split("-")[1]);
            if(dateDay>months){
                var month = NumUtils.oneToTwoOrThree(dateDay-months,2);
                return year+'-'+month+dateStrTime.substr(7,dateStrTime.length-1);
            }else{
                var monthRest = months-dateDay;
                year -=(parseInt(monthRest/12)+1);
                while(monthRest>12){
                    monthRest -=12;
                }
                dateDay = NumUtils.oneToTwoOrThree((12-monthRest),2);
                return year+'-'+dateDay+dateStrTime.substr(7,dateStrTime.length-1);
            }
        },
        /**
         * 获取一个月有多少天
         * @return {[type]}       [description]
         */
        getMonthOfDay(date) {
            var currentMonth = this.getFirstDayOfMonth(date);
            var nextMonth = this.getNextDayOfMonth(date);
            return this.numDay(currentMonth,nextMonth);
        },
        /**
         * 获取一年有多少天
         * @return {[type]}      [description]
         */
        getYearOfDay(date) {
            var firstDayYear = this.getFirstDayOfYear(date);
            var lastDayYear = this.getLastDayOfYear(date);
            return Math.ceil(this.numDay(firstDayYear,lastDayYear));
        },
        /**
         * 某个日期是当年中的第几天
         * @return {[type]}      [description]
         */
        getDayOfYear(date) {
            return Math.ceil(this.numDay(this.getFirstDayOfYear(date), date));
        },
        /**
         * 获取某个日期在这一年的第几周
         * @return {[type]}      [description]
         */
        getDayOfYearWeek(date) {
            var numdays = this.getDayOfYear(date);
            return Math.ceil(numdays / 7);
        },
        /**
         * 某个日期在当月星期几
         * @return {[type]}       [description]
         */
        getDayOfWeek(date) {
            return this.getWeek(date);
        },
        /**
         * 获取在当前日期中的小时
         * @return {[type]}      [description]
         */
        getHourOfDay(date) {
            return this.getHour(date);
        },
        /**
         * date2日期晚于date1
         * @return {[type]}       [description]
         */
        after(date1, date2) {
            var stime = this.getTime(this.transferDate(date1));
            var etime = this.getTime(this.transferDate(date2));
            return stime < etime ? true : false;
        },
        /**
         * 获取某年的第一天
         * @return {[type]}      [description]
         */
        getFirstDayOfYear(date) {
            var year = this.getYear(date);
            return year + "-01-01 00:00:00";
        },
        /**
         * 获取某年的最后一天
         * @return {[type]}      [description]
         */
        getLastDayOfYear(date) {
            var year = this.getYear(date);
            var dateString = year + "-12-01 00:00:00";
            var endDay = this._getMonthOfDay(dateString);
            return year + "-12-" + endDay + " 23:59:59";
        },
        /**
         * 一天的开始时间
         * @return {[type]}      [description]
         */
        getFirstOfDay(date) {
            var year = this.getYear(date);
            var month = this.getMonth(date);
            var dates = this.getDay(date);
            return year + "-" + month + "-" + dates + " 00:00:00";
        },
        /**
         * 一天的结束时间
         * @return {[type]}      [description]
         */
        getLastOfDay(date) {
            var year = this.getYear(date);
            var month = this.getMonth(date);
            var dates = this.getDay(date);
            return year + "-" + month + "-" + dates + " 23:59:59";
        },
        /**
         * 获取日期本周第一天(周日为第一天)
         * @return {[type]}       [description]
         */
        getFirstOfWeek(date1) {
            var week = this.getWeek(date1);
            var date = this.minusDays(date1, week);
            var year = this.getYear(date);
            var month = this.getMonth(date);
            var dates = this.getDay(date);
            return year + "-" + month + "-" + dates + " 00:00:00";
        },
        /**
         * 获取上周最后一天(周六为最后一天)
         * @return {[type]}       [description]
         */
        getLastOfWeek(date1) {
            var week = this.getWeek(date1)+1;
            var date = this.minusDays(date1,week);
            var year = this.getYear(date);
            var month = this.getMonth(date);
            var dates = this.getDay(date);
            return year + "-" + month + "-" + dates + " 23:59:59";
        },
        /**
         * 获取某月的第一天
         * @return {[type]}      [description]
         */
        getFirstDayOfMonth(date) {
            var year = this.getYear(date);
            var month = this.getMonth(date);
            return year + "-" + month + "-01 00:00:00";
        },
        /**
         * 获取某月的下个月的第一天
         * @return {[type]}      [description]
         */
        getNextDayOfMonth(date) {
            var year = this.getYear(date);
            var month = this.getMonth(date);
            month = month * 1 + 1;
            if(month > 12) {
                year = year + 1;
                month = month - 12;
            }
            month = month > 9 ? month : "0" + month;
            return year + "-" + month + "-01 00:00:00";
        },
        /**
         * 获取某月的最后一天
         * @return {[type]}      [description]
         */
        getLastDayOfMonth(date) {
            var endDay = this.getMonthOfDay(date);
            var year = this.getYear(date);
            var month = this.getMonth(date);
            return year + "-" + month + "-" + endDay + " 23:59:59";
        },



        /**
         * 获取现在时间
         * @return {[type]} [description]
         */
        getNow(){
            return new Date();
        },
        /**
         * 获取年份
         * @param  {[type]} date [description]
         * @return {[type]}      [description]
         */
        getYear(date) {
            return this.transferDate(date).getFullYear();
        },
        /**
         * 获取月份
         * @return {[type]}      [description]
         */
        getMonth(date) {
            var month = this.transferDate(date).getMonth() + 1;
            return month > 9 ? month : "0" + month;
        },
        /**
         * 获取日期
         * @return {[type]}      [description]
         */
        getDay(date) {
            var day = this.transferDate(date).getDate();
            return day > 9 ? day : "0" + day;
        },
        /**
         * 获取周几(0-周日)
         * @param  {[type]} date [description]
         * @return {[type]}      [description]
         */
        getWeek(date) {
            return this.transferDate(date).getDay();
        },
        /**
         * 获取小时----24小时制
         * @return {[type]}      [description]
         */
        getHou(date) {
            var hour = this.transferDate(date).getHours();
            return hour > 9 ? hour : "0" + hour;
        },
        /**
         * 获取小时----12小时制
         * @return {[type]}      [description]
         */
        getHour12(date) {
            var hour = this.transferDate(date).getHours();
            return hour % 12 == 0 ? 12 : hour % 12;
        },
        /**
         * 获取分钟
         * @return {[type]}      [description]
         */
        getMinute(date) {
            var minutes = this.transferDate(date).getMinutes();
            return minutes > 9 ? minutes : "0" + minutes;
        },
        /**
         * 获取秒
         * @return {[type]}      [description]
         */
        getSecond(date) {
            var seconds = this.transferDate(date).getSeconds();
            return seconds > 9 ? seconds : "0" + seconds;
        },
        /**
         * 获取毫秒
         * @return {[type]}      [description]
         */
        getMillisecond(date) {
            return this.transferDate(date).getMilliseconds();
        },
        /**
         * 获取时间是第几季度
         * @return {[type]}      [description]
         */
        getPeriod(date) {
            var month = this.getMonth(date) * 1;
            return Math.floor((month + 3) / 3);
        },
        /**
         * 星期几
         * @param  {[type]} date [description]
         * @return {[type]}      [description]
         */
        nowWeek(date) {
            var nowWeek = this.getWeek(date);
            var day = "";
            switch(nowWeek) {
                case 0: day = "日"; break;
                case 1: day = "一"; break;
                case 2: day = "二"; break;
                case 3: day = "三"; break;
                case 4: day = "四"; break;
                case 5: day = "五"; break;
                case 6: day = "六"; break;
            }
            return day;
        },



        /**
        * 将一段时长转换成友好格式，如：
        * 147->“2分27秒”
        * 1581->“26分21秒”
        * 15818->“4小时24分”
        * @param {Object} second
        */
        secondToFriendly(second){
            if(second < 60) return second + '秒';
            else if(second < 60*60) return (second-second%60)/60+'分'+second%60+'秒';
            else if(second < 60*60*24) return (second-second%3600)/60/60+'小时'+Math.round(second%3600/60)+'分';
            return (second/60/60/24).toFixed(1)+'天';
        },
        /**
         * 判断某年是否是闰年，不传为当前年份
         * @param  {[type]}  year [description]
         * @return {Boolean}      [description]
         */
        isLeapYear(year){
            if(year === undefined) year = new Date();
            if(year instanceof Date) year = year.getFullYear();
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        },
    },

    //*****************************************加载load工具类**************************************
    LoadUtils:{
        /*
         * 方法说明：【动态加载js文件css文件】
         * 使用方法：loadUtil.loadjscssfile("http://libs.baidu.com/jquery/1.9.1/jquery.js","js")
         * @param fileurl 文件路径，
         * @param filetype 文件类型，支持传入类型，js、css
         */
        loadJsCssFile(fileurl,filetype){
            if(filetype == "js"){
                var fileref = document.createElement('script');
                fileref.setAttribute("type","text/javascript");
                fileref.setAttribute("src",fileurl);

                document.body.appendChild(fileref);
            }else if(filetype == "css"){
                var fileref = document.createElement('link');
                fileref.setAttribute("rel","stylesheet");
                fileref.setAttribute("type","text/css");
                fileref.setAttribute("href",fileurl);

                document.getElementsByTagName('head').item(0).appendChild(css);
            }
        }
    },


    //*****************************************数组array工具类*************************************
    ArrayUtils:{
        /**
         * [each description]
         */
        each(arr,fn) {
            fn = fn || Function;
            var a = [];
            var args = Array.prototype.slice.call(arguments, 1);
            for(var i = 0; i < arr.length; i++) {
                var res = fn.apply(arr, [arr[i], i].concat(args));
                if(res != null) {
                    a.push(res);
                }
            }
            return a;
        },
        /**
         * 根据值获取数组的下标
         * @return  [没有则返回-1]
         */
        indexOf(arr,val) {
            for(var i = 0; i < arr.length; i++) {
                if(arr[i] == val) {
                    return i;
                }
            }
            return -1;
        },
        /**
         * 判断一个元素是否在数组中
         * @return [true/false]
         */
        contains(arr,val) {
            return this.indexOf(arr,val) != -1 ? true : false;
        },
        /**
         * 数组去重
         * @param  {[type]} array [description]
         * @return {[type]}       [返回一个新的数组]
         */
        unique(array){
            var n = []; //一个新的临时数组
            //遍历当前数组
            for(var i = 0; i < array.length; i++){
                if (n.indexOf(array[i]) == -1) {
                    n.push(array[i]);
                 }
            }
            return n;
        },
        /**
         * 数组排序
         * @param  asc(正序)/desc(倒序)
         * @return {[type]}          [description]
         */
        orderBy(arr, sortFlag) {
            if(sortFlag == 'asc') {
                arr.sort(function(a,b){
                    return a-b;
                });
            }else if(sortFlag == 'desc') {
                arr.sort(function(a,b){
                    return b-a;
                });
            }
            return arr;
        },
        /**
         * 求两个数组并集
         */
        union(arr1,arr2) {
            var newArr = arr1.concat(arr2);
            return this.unique(newArr);
        },
        /**
         * 求两个集合的补集
         * @return {[type]}   [description]
         */
        complement(arr1,arr2) {
            return this.minus(this.union(arr1,arr2), this.intersect(arr1,arr2));
        },
        /**
         * 求两集合的交集
         * @return {[type]}   [description]
         */
        intersect(arr1, arr2) {
            arr1 = this.unique(arr1);
            return this.each(arr1, function(o) {
                return ArrayUtils.contains(arr2,o) ? o : null;
            });
        },
        /**
         * 求两个集合的差集
         */
        minus(arr1,arr2) {
            arr1 = this.unique(arr1);
            return this.each(arr1, function(o) {
                return ArrayUtils.contains(arr2,o) ? null : o;
            });
        },
        /**
         * 数组中删除一个元素
         * @return {[type]}   [description]
         */
        removeValue(arr,indexs) {
            var index = this.indexOf(arr,indexs);
            if(index > -1) {
                arr.splice(index, 1);
            }
            return arr;
        },
        /**
         * 删除数组中某个重复的元素
         * @return {[type]}   [description]
         */
        removeRepeatValue(arr,indexs) {
            var index=0;
            while(index!=-1){
                index = this.indexOf(arr,indexs);
                if(index!=-1){
                    arr.splice(index,1);
                }
            }
            return arr;
        },
        /**
         * 求数组中最大值
         * @return {[type]}     [description]
         */
        arrMax(arr) {
            return Math.max.apply(null, arr);
        },
        /**
         * 求数组中最小值
         * @return {[type]}     [description]
         */
        arrMin(arr) {
            return Math.min.apply(null, arr);
        },
        /**
         * 类数组对象转为数组
         * @param  {0:42, 1:52, 2:63, length:3}
         * @return {[type]}     [42, 52, 63]
         */
        formArray(ary) {
            var arr = [];
            if(Array.isArray(ary)) {
                arr = ary;
            } else {
                arr = Array.prototype.slice.call(ary);
            };
            return arr;
        },
        /**
         * 求和数组函数
         * @return {[type]}     [description]
         */
        arySum(arr) {
            var ary = [];
            var result = 0;
            if(arr instanceof Array) {
                ary = arr;
            } else {
                ary = this.formArray(arr);
            };
            for(var i = 0; i < ary.length; i++) {
                result += parseFloat(ary[i]);
            };
            return result;
        },
        /**
         * 数组随机排列
         * @return {[type]}     [description]
         */
        shuffle(arr) {
            var input = arr;
            for(var i = input.length - 1; i >= 0; i--) {
                var randomIndex = Math.floor(Math.random() * (i + 1));
                var itemAtIndex = input[randomIndex];
                input[randomIndex] = input[i];
                input[i] = itemAtIndex;
            }
            return input;
        },
        /**
         * 随机返回数组中的一个元素
         * @param  {[type]} ary [description]
         * @return {[type]}     [description]
         */
        randomItem(ary) {
            return ary[Math.floor(Math.random() * ary.length)];
        },
        /**
         * 判断数组中是否包含某一项
         * @return {[type]}      [description]
         */
        arrContains(arr,str) {
            if(arr.length > 0) {
                for(var i = 0; i < arr.length; i++) {
                    if(arr[i] == str) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        },
        /**
         * 判断数组中是否有重复的项
         * @return {Boolean}     [description]
         */
        isRepeat(arr) { //arr是否有重复元素
            var hash = {};
            for(var i in arr) {
                if(hash[arr[i]]) return true;
                hash[arr[i]] = true;
            }
            return false;
        },
    },



    //*****************************************字符串string工具类***********************************
    StringUtils:{
        /*
         * 判断字符串是否为空
         * @param str 传入的字符串
         * @returns {}
         */
        isEmpty(str){
            if(str != null && str.length > 0){
                return false;
            }else{
                return true;
            }
        },
        /**
         * 判断是否非空
         * @return {Boolean}     [description]
         */
        isNotEmpty(val) {
            return !isEmpty(val);
        },
        /*
         * 判断两个字符串否相同
         */
        isEquals(str1,str2){
            if(str1==str2){
                return true;
            }else{
                return false;
            }
        },
        /*
         * 忽略大小写判断字符串是否相同
         */
        isEqualsIgnorecase(str1,str2){
            if(str1.toUpperCase() == str2.toUpperCase()){
                return true;
            }else{
                return false;
            }
        },
        /**
         * 判断是否纯数字
         */
        isNum(value){
            if( value != null && value.length>0 && isNaN(value) == false){
                return true;
            }else{
                return false;
            }
        },
        /**
         * 判断是否含有中文
         */
        isChinese(str){
            var reg = /^([u4E00-u9FA5]|[uFE30-uFFA0])*$/;
            if(reg.test(str)){
                return false;
            }
            return true;
        },
        /**
         * 把首字母和pattrn线的第一个字母变成大写
         * @param  {[type]} str    [order_buy]
         * @param  {[type]} pattrn ['/、-、_']
         * @return {[type]}        [OrderBuy]
         */
        changeUpperByStr(str,pattrn){
            var arr = str.split(pattrn);
            var joinStr = '';
            for(var i=0;i<arr.length;i++){
                var arrString = arr[i];
                joinStr +=arrString.substr(0,1).toUpperCase()+arrString.substr(1,arrString.length-1);
            }
            return joinStr;
        }
    },

    //*****************************************操作文件file工具类***********************************
    FileUtils:{

        /**
         * 文件大小转为MB/GB/KB/B
         * @return {[type]}      [description]
         */
        transformFileSize(size){
            var fsize = parseFloat(size, 2);
            var fileSizeString;
            if(fsize < 1024) {
                fileSizeString = fsize.toFixed(2) + "B";
            } else if(fsize < 1048576) {
                fileSizeString = (fsize / 1024).toFixed(2) + "KB";
            } else if(fsize < 1073741824) {
                fileSizeString = (fsize / 1024 / 1024).toFixed(2) + "MB";
            } else if(fsize < 1024 * 1024 * 1024) {
                fileSizeString = (fsize / 1024 / 1024 / 1024).toFixed(2) + "GB";
            } else {
                fileSizeString = "0B";
            }
            return fileSizeString;
        },
        /**
         * 获取文件后缀名
         * @return {[type]}          [description]
         */
        getFileExt(fileName) {
            var pos = fileName.lastIndexOf(".");
            if(pos == -1) {
                return fileName;
            } else {
                return fileName.substring(pos+1, fileName.length).toLowerCase();
            }
        },
        /**
         * 获取文件名称
         * @return {[type]}          [description]
         */
        getFileName(fileName) {
            var pos = fileName.lastIndexOf(".");
            if(pos == -1) {
                return fileName;
            } else {
                return fileName.substring(0,pos);
            }
        },
        /**
         * 过滤html代码(把<>转换)
         * @return {[type]}     [description]
         */
        filterTag(str) {
            str = str.replace(/&/ig, "&amp;");
            str = str.replace(/</ig, "&lt;");
            str = str.replace(/>/ig, "&gt;");
            str = str.replace(" ", "&nbsp;");
            return str;
        },
        /**
         * 判断是否为图片
         * @return {[type]}          [description]
         */
        checkIsImage(fileName){
            return /\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/ig.test(fileName);
        },
        /**
         * 判断是否为视频
         * @return {[type]}          [description]
         */
        checkVideo(fileName){
            return /\.(mp4|mp3|flv|wav)$/ig.test(fileName);
        },
        /**
         * 判断是否为文档
         * @return {[type]}          [description]
         */
        checkDocument(fileName) {
            return /\.(doc|docx|xls|xlsx|pdf|txt|ppt|pptx|rar|zip|html|jsp|sql|htm|shtml|xml)$/ig.test(fileName);
        },
        /**
         * 得到项目的基地址
         * @return {}
         */
        getBasePath(){
            var strFullPath = window.document.location.href;
            var strPath = window.document.location.pathname;
            var pos = strFullPath.indexOf(strPath);
            var prePath = strFullPath.substring(0, pos);
            var path = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            return path;
        }
    },


    //*****************************************浏览器检测等工具类************************************
    BrowserUtils: {
        /**
         * 获取浏览器名称
         * @return {[type]} [description]
         */
        getBrowseType() {
            var sUA = navigator.userAgent;
            //检测IE浏览器
            if((navigator.appName == "Microsoft Internet Explorer")) {
                //检测模拟IE浏览的OPERA。edit at 2006-11-08(ver 0.1.2)
                if(sUA.indexOf('Opera') != -1) {
                    this.browseKernel = 'Presto';
                    if(window.opera && document.childNodes) {
                        return 'Opera 7+';
                    } else {
                        return 'Opera 6-';
                    }
                }
                this.browseKernel = 'Trident';
                if(sUA.indexOf('Maxthon') != -1) {
                    return 'Maxthon';
                }
                if(sUA.indexOf('TencentTraveler') != -1) { //ver 0.1.3
                    return '腾迅TT';
                }
                if(document.getElementById) {
                    return "IE5+";
                } else {
                    return "IE4-";
                }
            }
            //检测Gecko浏览器
            if(sUA.indexOf('Gecko') != -1) {
                this.browseKernel = 'Gecko';
                if(navigator.vendor == "Mozilla") {
                    return "Mozilla";
                }
                if(navigator.vendor == "Firebird") {
                    return "Firebird";
                }
                if(navigator.vendor.indexOf('Google') != -1 || sUA.indexOf('Google') != -1) {
                    return 'Google';
                }
                if(sUA.indexOf('Firefox') != -1) {
                    return 'Firefox';
                }
                return "Gecko";
            }
            //Netscape浏览器
            if(sUA.indexOf('Netscape') != -1) {
                this.browseKernel = 'Gecko';
                if(document.getElementById) {
                    return "Netscape 6+";
                } else {
                    return 'Netscape 5-';
                }
            }
            //检测Safari浏览器
            if(sUA.indexOf('Safari') != -1) {
                this.browseKernel = 'KHTML';
                return 'Safari';
            }
            if(sUA.indexOf('konqueror') != -1) {
                this.browseKernel = 'KHTML';
                return 'Konqueror';
            }
            //目前世界公认浏览网页速度最快的浏览器，但它占用的系统资源也很大。
            if(sUA.indexOf('Opera') != -1) {
                this.browseKernel = 'Presto';
                if(window.opera && document.childNodes) {
                    return 'Opera 7+';
                } else {
                    return 'Opera 6-';
                }
                return 'Opera';
            }
            if((sUA.indexOf('hotjava') != -1) && typeof(navigator.accentColorName) == 'undefined') {
                return 'HotJava';
            }
            if(document.all && document.getElementById && navigator.savePreferences && (sUA.indexOf('netfront') < 0) && navigator.appName != 'Blazer') {
                return 'Escape 5';
            }
            //Konqueror / Safari / OmniWeb 4.5+
            if(navigator.vendor == 'KDE' || (document.childNodes && (!document.all || navigator.accentColorName) && !navigator.taintEnabled)) {
                this.browseKernel = 'KHTML';
                return 'KDE';
            }
            if(navigator.__ice_version) {
                return 'ICEbrowser';
            }
            if(window.ScriptEngine && ScriptEngine().indexOf('InScript') + 1) {
                if(document.createElement) {
                    return 'iCab 3+';
                } else {
                    return 'iCab 2-';
                }
            }
            if(document.layers && !document.classes) {
                return 'Omniweb 4.2-';
            }
            if(document.layers && !navigator.mimeTypes['*']) {
                return 'Escape 4';
            }
            if(navigator.appName.indexOf('WebTV') + 1) {
                return 'WebTV';
            }
            if(sUA.indexOf('netgem') != -1) {
                return 'Netgem NetBox';
            }
            if(sUA.indexOf('opentv') != -1) {
                return 'OpenTV';
            }
            if(sUA.indexOf('ipanel') != -1) {
                return 'iPanel MicroBrowser';
            }
            if(document.getElementById && !document.childNodes) {
                return 'Clue browser';
            }
            if(document.getElementById && ((sUA.indexOf('netfront') != -1) || navigator.appName == 'Blazer')) {
                return 'NetFront 3+';
            }
            if((sUA.indexOf('msie') + 1) && window.ActiveXObject) {
                return 'Pocket Internet Explorer';
            }
            return "Unknown";
        },
        /**
         * 获取浏览器类型和版本
         * @return {[type]} [description]
         */
        getBrowseType() {
            return new function(){
                var Browser_Name = navigator.appName;
                var Browser_Version = parseFloat(navigator.appVersion);
                var Browser_Agent = navigator.userAgent;
                var Actual_Version, Actual_Name;
                var is_IE = (Browser_Name == "Microsoft Internet Explorer"); //判断是否为ie浏览器
                var is_NN = (Browser_Name == "Netscape"); //判断是否为netscape浏览器
                var is_op = (Browser_Name == "Opera"); //判断是否为Opera浏览器
                if(is_NN) {
                    //upper 5.0 need to be process,lower 5.0 return directly
                    if(Browser_Version >= 5.0) {
                        if(Browser_Agent.indexOf("Netscape") != -1) {
                            var Split_Sign = Browser_Agent.lastIndexOf("/");
                            var Version = Browser_Agent.lastIndexOf(" ");
                            var Bname = Browser_Agent.substring(0, Split_Sign);
                            var Split_sign2 = Bname.lastIndexOf(" ");
                            Actual_Version = Browser_Agent.substring(Split_Sign + 1, Browser_Agent.length);
                            Actual_Name = Bname.substring(Split_sign2 + 1, Bname.length);
                        }
                        if(Browser_Agent.indexOf("Firefox") != -1) {
                            var Version = Browser_Agent.lastIndexOf("Firefox");
                            Actual_Version = Browser_Agent.substring(Version + 8, Browser_Agent.length);
                            Actual_Name = Browser_Agent.substring(Version, Version + 7);
                        }
                        if(Browser_Agent.indexOf("Safari") != -1) {
                            if(Browser_Agent.indexOf("Chrome") != -1) {
                                var Split_Sign = Browser_Agent.lastIndexOf(" ");
                                var Version = Browser_Agent.substring(0, Split_Sign);;
                                var Split_Sign2 = Version.lastIndexOf("/");
                                var Bname = Version.lastIndexOf(" ");
                                Actual_Version = Version.substring(Split_Sign2 + 1, Version.length);
                                Actual_Name = Version.substring(Bname + 1, Split_Sign2);
                            } else {
                                var Split_Sign = Browser_Agent.lastIndexOf("/");
                                var Version = Browser_Agent.substring(0, Split_Sign);;
                                var Split_Sign2 = Version.lastIndexOf("/");
                                var Bname = Browser_Agent.lastIndexOf(" ");
                                Actual_Version = Browser_Agent.substring(Split_Sign2 + 1, Bname);
                                Actual_Name = Browser_Agent.substring(Bname + 1, Split_Sign);
                            }
                        }
                        if(Browser_Agent.indexOf("Trident") != -1) {
                            Actual_Version = Browser_Version;
                            Actual_Name = Browser_Name;
                        }
                    } else {
                        Actual_Version = Browser_Version;
                        Actual_Name = Browser_Name;
                    }
                } else if(is_IE) {
                    var Version_Start = Browser_Agent.indexOf("MSIE");
                    var Version_End = Browser_Agent.indexOf(";", Version_Start);
                    Actual_Version = Browser_Agent.substring(Version_Start + 5, Version_End)
                    Actual_Name = Browser_Name;

                    if(Browser_Agent.indexOf("Maxthon") != -1 || Browser_Agent.indexOf("MAXTHON") != -1) {
                        var mv = Browser_Agent.lastIndexOf(" ");
                        var mv1 = Browser_Agent.substring(mv, Browser_Agent.length - 1);
                        mv1 = "遨游版本:" + mv1;
                        Actual_Name += "(Maxthon)";
                        Actual_Version += mv1;
                    }
                } else if(Browser_Agent.indexOf("Opera") != -1) {
                    Actual_Name = "Opera";
                    var tempstart = Browser_Agent.indexOf("Opera");
                    var tempend = Browser_Agent.length;
                    Actual_Version = Browser_Version;
                } else {
                    Actual_Name = "Unknown Navigator"
                    Actual_Version = "Unknown Version"
                }
                navigator.Actual_Name = Actual_Name;
                navigator.Actual_Version = Actual_Version;
                this.Name = Actual_Name;
                this.Version = Actual_Version;
                this.isFirefox = function() {
                    if(Actual_Name.indexOf("Firefox") == -1)
                        return false;
                    else
                        return true;
                }
                this.isSafari = function() {
                    if(Actual_Name.indexOf("Safari") == -1)
                        return false;
                    else
                        return true;
                }
                this.isChrome = function() {
                        if(Actual_Name.indexOf("Chrome") == -1)
                            return false;
                        else
                            return true;
                    }
                    //判读是否为ie浏览器
                this.isIE = function() {
                        if(Browser_Name == "Microsoft Internet Explorer")
                            return false;
                        else
                            return true;
                    }
                    //判读是否为ie6浏览器
                this.isCurrIE6 = function() {
                        if(Browser_Agent.toLowerCase().indexOf("msie 6.0") != -1)
                            return false;
                        else
                            return true;
                    }
                    //判读是否为ie7浏览器
                this.isCurrIE6 = function() {
                        if(Browser_Agent.toLowerCase().indexOf("msie 7.0") != -1)
                            return false;
                        else
                            return true;
                    }
                    //判读是否为ie8浏览器
                this.isCurrIE9 = function() {
                        if(Browser_Agent.toLowerCase().indexOf("msie 8.0") != -1)
                            return false;
                        else
                            return true;
                    }
                    //判读是否为ie9浏览器
                this.isCurrIE10 = function() {
                        if(Browser_Agent.toLowerCase().indexOf("msie 9.0") != -1)
                            return false;
                        else
                            return true;
                    }
                    //判读是否为ie11浏览器
                this.isCurrIE11 = function() {
                    if((Browser_Name == "Netscape") && (parseFloat(Browser_Version) >= 5.0) && (Browser_Agent.indexOf("Trident") != -1))
                        return false;
                    else
                        return true;
                }

            };
        }
    },


    //*******************************************UUID工具类****************************************
    UUIDUtils:{
        /**
         * 获取UUID
         * @return {[type]} [description]
         */
        getUUID(){
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
              var r = (d + Math.random()*16)%16 | 0;
              d = Math.floor(d/16);
              return (c=='x' ? r : (r&0x3|0x8)).toString(16);
            });
            return uuid.replace(/-/g,'');
        },
        /**
         * 基于参数(2/8/10/16进制获取uuid)
         * @param radix为2、8、10、16
         * @return {[type]} [description]
         */
        getBaseUUID(radix) {
            var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
            var uuid = [], i;
            radix = radix || chars.length;

            for (i = 0; i < 32; i++) {
                uuid[i] = chars[0 | Math.random()*radix];
            }

            return uuid.join('');
        }
    }
}


















