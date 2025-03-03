const {defineConfig} = require('@vue/cli-service');

module.exports = defineConfig({
    transpileDependencies: true, // 转译依赖
    devServer: {
        port: 8080, // 开发服务器端口
        open: true, // 自动打开浏览器
        proxy: {
            '/api': {
                target: 'http://localhost:8081', // 后端 API 地址
                changeOrigin: true, // 允许跨域
                pathRewrite: {'^/api': ''} // 重写路径
            }
        }
    },
    lintOnSave: false // 关闭保存时 lint 检查
});