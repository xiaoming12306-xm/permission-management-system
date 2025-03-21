const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true, // 转译所有 node_modules 中的依赖
  devServer: {
    port: 8081, // 前端开发服务器端口
    proxy: {
      // 配置代理，解决跨域问题
      '/api': {
        target: 'http://localhost:8080', // 后端 API 地址
        changeOrigin: true, // 允许跨域
        pathRewrite: {
          '^/api': '', // 重写路径，去掉 /api 前缀
        },
      },
    },
  },
  css: {
    loaderOptions: {
      // 全局引入样式文件
      scss: {
        additionalData: `
          @import "@/assets/css/global.scss";
          @import "@/assets/css/theme.scss";
        `,
      },
    },
  },
  configureWebpack: {
    // 配置 Webpack
    resolve: {
      alias: {
        // 配置路径别名
        '@': path.resolve(__dirname, 'src'),
      },
    },
  },
  chainWebpack: (config) => {
    // 配置 SVG 图标加载器
    config.module
      .rule('svg')
      .exclude.add(path.resolve(__dirname, 'src/assets/icons'))
      .end();

    config.module
      .rule('icons')
      .test(/\.svg$/)
      .include.add(path.resolve(__dirname, 'src/assets/icons'))
      .end()
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]',
      })
      .end();
  },
});