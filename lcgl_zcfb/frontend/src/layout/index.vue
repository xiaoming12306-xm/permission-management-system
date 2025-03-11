<template>
  <el-container class="layout-container">
    <el-aside :width="isCollapse ? '64px' : '200px'">
      <div class="logo">
        <img src="@/assets/logo.png" alt="logo">
        <span v-show="!isCollapse">事务</span>
      </div>
      
      <el-menu
        :default-active="activeMenu"
        class="el-menu-vertical"
        :collapse="isCollapse"
        background-color="#304156"
        text-color="#bfcbd9"
        active-text-color="#409EFF"
        router
      >
        <el-menu-item index="/form">
          <el-icon><Document /></el-icon>
          <template #title>表单管理</template>
        </el-menu-item>
        
        <el-menu-item index="/approval">
          <el-icon><Check /></el-icon>
          <template #title>审批管理</template>
        </el-menu-item>
        
        <el-menu-item index="/user">
          <el-icon><User /></el-icon>
          <template #title>用户管理</template>
        </el-menu-item>
      </el-menu>
    </el-aside>
    
    <el-container>
      <el-header>
        <div class="header-left">
          <el-icon
            class="collapse-btn"
            @click="toggleCollapse"
          >
            <Fold v-if="!isCollapse" />
            <Expand v-else />
          </el-icon>
        </div>
        
        <div class="header-right">
          <el-dropdown @command="handleCommand">
            <span class="user-info">
              {{ userInfo.username }}
              <el-icon><ArrowDown /></el-icon>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>
      
      <el-main>
        <router-view v-slot="{ Component }">
          <transition name="fade" mode="out-in">
            <component :is="Component" />
          </transition>
        </router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { Document, Check, User, Fold, Expand, ArrowDown } from '@element-plus/icons-vue'
import { ElMessageBox } from 'element-plus'
import { logout } from '@/auth'

const router = useRouter()
const route = useRoute()
const isCollapse = ref(false)
const userInfo = ref({
  username: 'Admin'
})

const activeMenu = computed(() => route.path)

const toggleCollapse = () => {
  isCollapse.value = !isCollapse.value
}

const handleCommand = async (command) => {
  if (command === 'logout') {
    try {
      await ElMessageBox.confirm('确定要退出登录吗？', '提示', {
        type: 'warning'
      })
      await logout()
      localStorage.removeItem('token')
      router.push('/views/login')
    } catch (error) {
      console.error('退出登录失败:', error)
    }
  }
}
</script>

<style lang="scss" scoped>
.layout-container {
  height: 100vh;
  
  .el-aside {
    background-color: #304156;
    transition: width 0.3s;
    
    .logo {
      height: 60px;
      display: flex;
      align-items: center;
      padding: 0 20px;
      color: #fff;
      
      img {
        width: 32px;
        height: 32px;
        margin-right: 12px;
      }
    }
    
    .el-menu {
      border-right: none;
    }
  }
  
  .el-header {
    background-color: #fff;
    border-bottom: 1px solid $border-color-light;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 20px;
    
    .collapse-btn {
      font-size: 20px;
      cursor: pointer;
      
      &:hover {
        color: $primary-color;
      }
    }
    
    .user-info {
      display: flex;
      align-items: center;
      cursor: pointer;
      
      .el-icon {
        margin-left: 4px;
      }
    }
  }
  
  .el-main {
    background-color: $background-color-base;
    padding: 20px;
  }
}
</style> 