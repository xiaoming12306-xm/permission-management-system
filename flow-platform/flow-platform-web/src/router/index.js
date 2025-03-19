import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import Login from '@/views/Login.vue';
import Dashboard from '@/views/Dashboard.vue';
import UserManagement from '@/views/UserManagement.vue';
import ApprovalFlow from '@/views/ApprovalFlow.vue';
import FormManagement from '@/views/FormManagement.vue';
import NotFound from '@/views/NotFound.vue';
import store from '@/store';

// requiresAuth：是否需要认证
// roles：允许访问的角色列表

// 路由配置
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: { requiresAuth: false }, // 不需要认证
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: { requiresAuth: false }, // 不需要认证
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard,
    meta: { requiresAuth: true }, // 需要认证
  },
  {
    path: '/users',
    name: 'UserManagement',
    component: UserManagement,
    meta: { requiresAuth: true, roles: ['ADMIN'] }, // 需要认证且角色为 ADMIN
  },
  {
    path: '/approval-flows',
    name: 'ApprovalFlow',
    component: ApprovalFlow,
    meta: { requiresAuth: true }, // 需要认证
  },
  {
    path: '/forms',
    name: 'FormManagement',
    component: FormManagement,
    meta: { requiresAuth: true }, // 需要认证
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound,
    meta: { requiresAuth: false }, // 不需要认证
  },
];
// 路由懒加载
/**
const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/Home.vue'),
    meta: { requiresAuth: false },
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue'),
    meta: { requiresAuth: false },
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: () => import('@/views/Dashboard.vue'),
    meta: { requiresAuth: true },
  },
  {
    path: '/users',
    name: 'UserManagement',
    component: () => import('@/views/UserManagement.vue'),
    meta: { requiresAuth: true, roles: ['ADMIN'] },
  },
  {
    path: '/approval-flows',
    name: 'ApprovalFlow',
    component: () => import('@/views/ApprovalFlow.vue'),
    meta: { requiresAuth: true },
  },
  {
    path: '/forms',
    name: 'FormManagement',
    component: () => import('@/views/FormManagement.vue'),
    meta: { requiresAuth: true },
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: () => import('@/views/NotFound.vue'),
    meta: { requiresAuth: false },
  },
];
*/

// 创建路由实例
const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 全局前置守卫
router.beforeEach((to, from, next) => {
  const isAuthenticated = store.getters.isAuthenticated;
  const userRoles = store.getters.userRoles;

  // 检查是否需要认证
  if (to.meta.requiresAuth && !isAuthenticated) {
    next({ name: 'Login' });
    return;
  }

  // 检查角色权限
  if (to.meta.roles && !to.meta.roles.some((role) => userRoles.includes(role))) {
    next({ name: 'Dashboard' }); // 无权限则重定向到 Dashboard
    return;
  }

  next();
});

export default router;