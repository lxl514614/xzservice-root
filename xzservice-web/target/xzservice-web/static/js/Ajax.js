/**
 * Created by Administrator on 15-2-6.
 */
/**
 * Created by Administrator on 14-12-10.
 */
(function(){
    /**
     * GetData.AjaxGetData(param1,param2,param3,callback)
     * 使用Ajax获取数据
     * @param1:接口名（必须）
     * callback：返回方法（必须）
     * @param3:服务器名（非必须，默认为getHot）
     * GetData.AjaxGetData(type,callback,serverType)//实例
     **/
    /**
     * GetData.changeParam(param1,param2,param3)
     * 使用Ajax获取数据
     * @param1:接口名（必须）
     * @param2：param修改位置（必须）
     * @param3:修改内容（必须）
     * GetData.AjaxGetData(type,callback,serverType)//实例
     **/
    window.GetData=function(){};
    GetData.extend = jQuery.extend;
    GetData.extend({
        AjaxNum:0,
        AjaxCreateNum:[],
        toMail:"",
        eCharts:'',
        LeadingBrandConfig :{
            server:'http://monitor.haina-service.com/',//数据接口服务器
            //server:'http://122.112.15.168:8018',//数据接口服务器
//            loginUrl:'http://www.analysys.cn/redirect.html?service=',
//            eurUrl:'http://www.userradar.com/index.php/mobile/item_jump?id=',
            path:'/x3ui/hbs/source/cacgov/',//数据接口地址
            newPath:'/x3ui/hbs/source/cacgov/',
            returnSort:"",

            /**
             * 公共方法
             **/
            //媒体类型
            getSourceList:{key:"getsourcelist/",param:{"loginid":"7362","format":"json"}},
            //新闻辅助巡查
            getElems:{key:"getelems/",param:{"loginid":"7362","format":"json","sids":""}}


        },
        getServerUrl:function(type){
            switch (type){
                case "getHot":
                    return this.LeadingBrandConfig.server+this.LeadingBrandConfig.path;
                    break;
                default :
                    return this.LeadingBrandConfig.server+this.LeadingBrandConfig.path;
            }
        },
        getParam:function(type){
            if(arguments.length>1&&arguments[1]=="param"){
                var param = '';
                if(JSON.stringify(this.LeadingBrandConfig[type].param)!="{}"){
                    param = '?';
                    for(var key in this.LeadingBrandConfig[type].param){
                        if(param.length>1)
                            param+="&"+key+'='+this.LeadingBrandConfig[type].param[key];
                        else
                            param+=key+'='+this.LeadingBrandConfig[type].param[key];
                    }
                }

                return this.LeadingBrandConfig[type].key+param;
            }
            return this.LeadingBrandConfig[type].param;
        },
        AjaxGetData:function(){
            $(".loading").show();
            var serverType="";
            var urlType = arguments[0];
            var callback = arguments[1];
            if (arguments.length != 2&&arguments[2]) {
                serverType = arguments[2];
                var serverUrl = this.getServerUrl(serverType);
            } else {
                var serverUrl = this.getServerUrl("getHot");
            }

            if(!this.AjaxCreateNum[urlType])
                this.AjaxCreateNum[urlType]=3;

            var paramtype = this.getParam(urlType);
            this.AjaxNum++;
            var url = serverUrl+this.LeadingBrandConfig[urlType]["key"];
            $.ajax({
                type:"post",
                url: url,
                data:paramtype,
                success:function(data){
                    $(".loading").hide();
                    if(data["code"]=="403"&&data["redirectUrl"]){
                        location.href=data["redirectUrl"];
                        return;
                    }
                    callback(data);
                    GetData.AjaxNum--;
                    if(GetData.AjaxNum<=0){
                        GetData.AjaxNum=0;
                    }
                },
                error:function(){
                    GetData.AjaxNum--;
                    if(GetData.AjaxNum<=0){
                        GetData.AjaxNum=0;
                    }

                    if(arguments[1]=="timeout"){
                        if(GetData.AjaxCreateNum[urlType]<1){
                            GetData.AjaxCreateNum[urlType]=3;
                            return;
                        }
                        GetData.AjaxGetData(urlType,callback,serverType);
                        GetData.AjaxCreateNum[urlType]--;
                    }

                }
            });
        },
        AjaxGetJsonData:function(){
            var serverType="";
            var urlType = arguments[0];
            var callback = arguments[1];
            if (arguments.length != 2&&arguments[2]) {
                serverType = arguments[2];
                var serverUrl = this.getServerUrl(serverType);
            } else {
                var serverUrl ="http://monitor.haina-service.com/"+this.LeadingBrandConfig.newPath; //this.LeadingBrandConfig.server+this.LeadingBrandConfig.newPath;
            }

            if(!this.AjaxCreateNum[urlType])
                this.AjaxCreateNum[urlType]=3;

            var paramtype = this.getParam(urlType);
            this.AjaxNum++;
            var url = serverUrl+this.LeadingBrandConfig[urlType]["key"];
//            $(".waitingLoading").show();
            $.ajax({
                dataType:"jsonp",
                url: url,
                data:paramtype,
                jsonp:"callback",
                timeout:5000,
                success:function(data){
                    if(data["code"]=="403"&&data["redirectUrl"]){
                        location.href=data["redirectUrl"];
                        return;
                    }
                    callback(data);
                    GetData.AjaxNum--;
                    if(GetData.AjaxNum<=0){
//                        $(".waitingLoading").hide();
                        GetData.AjaxNum=0;
                    }
                },
                error:function(){
                    GetData.AjaxNum--;
                    if(GetData.AjaxNum<=0){
//                        $(".waitingLoading").hide();
                        GetData.AjaxNum=0;
                    }

                    if(arguments[1]=="timeout"){
                        if(GetData.AjaxCreateNum[urlType]<1){
                            GetData.AjaxCreateNum[urlType]=3;
                            return;
                        }
                        GetData.AjaxGetData(urlType,callback,serverType);
                        GetData.AjaxCreateNum[urlType]--;
                    }

                }
            });
        },

/*        changeParam:function(){
            var type = arguments[0];
            var key =arguments[1];
            var value =arguments[2];
            this.AjaxNum=0;
            getParamKey(GetData.LeadingBrandConfig[type].param,key,value);

        },*/
        changeParam:function(){
            var type = arguments[0];
            var nParam = arguments[1];
            if(nParam == null || nParam == ""){
                return ;
            }
            this.AjaxNum=0;
            if($.type(nParam) == "object"){
                for(p in nParam){
                    getParamKey(GetData.LeadingBrandConfig[type].param,p,nParam[p]);
                }
            }else{
                var value = arguments[2];
                getParamKey(GetData.LeadingBrandConfig[type].param,nParam,value);
            }
        },
        getSort:function(){
//            var type = $.trim(arguments[0]);
            try{
                return this.LeadingBrandConfig.returnSort;
//                return this.LeadingBrandConfig[type].param.data.standardSort;
            }catch (e){
                return false;
            }
        },
        setSort:function(){
            if(!arguments[0])
                return;
            this.LeadingBrandConfig.returnSort = arguments[0];
//            return this.LeadingBrandConfig.returnSort;
        }
        ,
        getstartDate:function(){
            var type = $.trim(arguments[0]);
            try{
                return this.LeadingBrandConfig[type].param.data.startDate;
            }catch (e){
                return false;
            }
        }
    });

    GetData.extend({
        getCookie:function(){
            var key = arguments[0];
            if(!key)
                key = 'UserInfo';

            if(!$.cookie(key+'Length'))
                return false;

            var cookieLength=$.cookie(key+'Length');
            var cookieValue = "";
            for(var i=0;i<cookieLength;i++){
                cookieValue+=$.cookie((key+i));
            }

            return decodeURI($.base64.decode(cookieValue));
        },
        setCookie:function(){
            var Info=arguments[0];
            var key = arguments[1];
            if(!key)
                key = 'UserInfo';

            if(typeof Info=='object'){
                Info=JSON.stringify(Info);
            }
            var value = $.base64.encode(encodeURI(Info));
            var cookieLength = Math.ceil(value.length/1200);
            for(var i=0;i<cookieLength;i++){
                var start = i*1200;
                var end = (i+1)*1200;
                if(end>value.length)
                    end = value.length;

                var valueSide = value.substring(start,end);
                $.cookie((key+i),valueSide,{ expires: 7 });
            }

            $.cookie((key+'Length'),cookieLength,{ expires: 7 });
        },
        removeCookie:function(){
            var key = arguments[0];
            if(!key)
                key = 'UserInfo';

            var cookieLength=$.cookie(key+'Length');
            if(!cookieLength){
                $.cookie(key,"");
            }else{
                for(var i=0;i<cookieLength;i++){
                    $.cookie((key+i),"");
                }
            }
            $.cookie(key+'Length','');

        }
    });

    function getParamKey(){
        var _this =arguments[0];
        var key = arguments[1];
        var value = arguments[2];
        var keylist,__this;

        if(key.indexOf(".")>0){
            keylist =key.split(".");

            for(var i=0;i<keylist.length-1;i++){
                if(!__this){

                    __this=_this[keylist[i]]

                }else{
                    __this=__this[keylist[i]];

                }
            }
            __this[keylist[keylist.length-1]]=value;
        }else{
            _this[key]=value;
        }
    }
    GetData.extend({
        eChartsObj:function(){
            var obj = arguments[0];
            if(obj)
                this.eCharts = obj;
            return this.eCharts;
        }
    });
})();