import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 부트스트랩
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

// 비디오
import Vue3VideoPlayer from '@cloudgeek/vue3-video-player'
import '@cloudgeek/vue3-video-player/dist/vue3-video-player.css'

createApp(App).use(store).use(router).use(Vue3VideoPlayer, {lang: 'zh-CN'}).mount('#app')
