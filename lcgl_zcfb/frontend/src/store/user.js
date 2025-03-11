import { defineStore } from 'pinia'
import { login as loginApi, getUserInfo } from '@/user'

export const useUserStore = defineStore('user', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    userInfo: null
  }),
  
  getters: {
    isLoggedIn: (state) => !!state.token
  },
  
  actions: {
    async login(loginData) {
      try {
        const { data } = await loginApi(loginData)
        this.token = data.token
        localStorage.setItem('token', data.token)
        await this.fetchUserInfo()
        return data
      } catch (error) {
        this.token = ''
        localStorage.removeItem('token')
        throw error
      }
    },
    
    async fetchUserInfo() {
      try {
        const { data } = await getUserInfo()
        this.userInfo = data
        return data
      } catch (error) {
        this.userInfo = null
        throw error
      }
    },
    
    logout() {
      this.token = ''
      this.userInfo = null
      localStorage.removeItem('token')
    }
  }
}) 