const path = require('path')  //导入node.js 中专门操作路径的模块

//1.导入HTML html-webpack-plugin插件，得到一个构造函数
const HtmlPlugin = require('html-webpack-plugin')
//2.new 构造函数 创建HTML 插件的示例对象 
const htmlPlugin = new HtmlPlugin({
    template: './src/index.html',  //指定源文件的存放路径 要复制的哪个页面
    filename: './index.html',      //指定生成的文件的存放路径  复制出来的文件名和存放路径
})

//注意：左侧的 {} 是解构赋值
const { CleanWebpackPlugin } = require('clean-webpack-plugin')

//使用 node.js  中的导出语法，向外倒出一个webpack的配置对象
module.exports = {
    //代表 webpack运行的模式，可选值有两个  development (开发环境)  和  production(上线环境)
    mode: 'development',   //项目开发阶段使用
    // mode: 'production'  //项目开发完之后需要上线再使用


    //结论；开发时候一定要用development，因为上线追求的是打包的速度，而不是体积；
    //反过来，发布上线的时候一定要用production，因为上线追求的是体积小，而不是打包速度快


    // entry: '指定要处理哪个文件'
    entry: path.join(__dirname, './src/index.js'),  // 打包入口文件的路径
    output: {
        path: path.join(__dirname, './dist'),        //输出文件的存放路径  jion()括号里面不填默认为dist目录下
        filename: 'js/bundle.js',                      //输出文件的名称      文件名不写默认为main.js
    },

    //3. 插件html-webpack-plugin的数组，将来webpack在运行时，回加载并调用这些插件
    plugins: [htmlPlugin, new CleanWebpackPlugin],

    //devServer 节点
    devServer: {
        open: true,   		// 初次打包完成后，自动打开浏览器
        host: '127.0.0.1',   	//实时打包所使用的的主机地址
        port: 80,   		//实时打包所使用的的端口号
    },

    //配置.css 和 .less 的loader加载
    module: {                   //所有第三方文件模块的匹配规则
        rules: [                //文件后缀名的匹配规则
            //处理.css 文件的loader
            { test: /\.css$/, use: ['style-loader', 'css-loader'] },
            //处理.less 文件的loader
            { test: /\.less$/, use: ['style-loader', 'css-loader', 'less-loader'] },
            //处理url路径相关的文件  
            //在配置url-loader的时候，多个参数使用 & 符号进行分隔
            { test: /\.jpg|png|gif$/, use: 'url-loader?limit=22229&outputPath=images' },
            //使用babel-loader 处理高级的JS语法
            //在配置babel-loader 的时候，程序员只需要把字节的代码进行转换即可，一定要使用exclude排除node_moudles 目录中的JS文件
            //因为第三方包中的JS 兼容性不需要程序员关心
            { test: /\.js$/, use: 'babel-loader', exclude: /node_modules/ }
        ]
    },

    //在开发调试阶段，建议大家都把devtool的值设置为 eval-source-map
    // devtool:'eval-source-map',
    //在实际发布的时候，建议大家把devtool 的值设置为 nosources-source-map 或直接关闭 Source Map
    devtool: 'nosources-source-map',


    resolve: {
        alias: {
            //告诉webpack 程序员写的代码中，@ 符号表示src 这一层目录
            '@': path.join(__dirname, './src/')
        }
    }
}