import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue'

export default defineConfig({
    plugins: [vue()],
    build: {
        rollupOptions: {
            input: {
                main: './src/main.js' // 明确指定入口文件
            }
        }
    },
    optimizeDeps: {
        include: [
            'vue',          // 示例：预构建 Vue
            'lodash-es',    // 示例：预构建 lodash-es
            'your-library'  // 需要预构建的其他库
        ]
    },
    server: {
        port: 8081, // 前端开发服务器端口
        proxy: {
            '/api': {
                target: 'http://localhost:8080', // 后端 API 地址
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, '')
            }
        }
    }
});