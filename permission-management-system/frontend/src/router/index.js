import {createRouter, createWebHistory} from 'vue-router';
import Login from '../views/Login.vue';
import Home from '../views/Home.vue';

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: Login,
    },
    {
        path: '/',
        name: 'Home',
        component: Home,
        meta: {requiresAuth: true}, // 需要登录
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;