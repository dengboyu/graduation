# vue框架

> 集pc-移动端的vue框架

## 目录
``` bash
.
├── build                               //生产配置文件
├── config                              //配置文件
├── src                                 //源码
│   ├── common                          //pc端、移动端公共文件
│   │   ├── api                         //抽离api
│   │   ├── load                        //load加载文件动画
│   │   ├── message                     //message弹出消息框
│   │   └── utils                       //公共类原生js
│   ├── computer                        //pc端
│   │   ├── components                  //组件
│   │   │   ├── index                   //主页
│   │   │   ├── login                   //登录页
│   │   │   ├── public                  //公共组件
│   │   │   └── route                   //路线产品
│   │   │       ├── finance             //财务模块
│   │   │       ├── order               //订单模块
│   │   │       └── product             //产品模块
│   │   ├── router                      //router路由
│   │   └── store                       //数据管理状态
│   │       └── modules                 //模块
│   └── mobile                          //移动端
│       ├── components                  //组件
│       └── router                      //路由
└── static                              //静态资源
    ├── css                             //css
    ├── img                             //图片
    └── plugin                          //自定义和第三方插件
        └── customize                   //自定义插件
```

## 安装方法
``` bash
# install dependencies
npm install

# serve with hot reload at localhost:3008
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

