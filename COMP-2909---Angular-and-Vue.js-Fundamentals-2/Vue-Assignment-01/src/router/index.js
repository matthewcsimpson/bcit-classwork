import Vue from 'vue'
import Router from 'vue-router'
import inputpage from '@/components/inputpage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'inputpage',
      component: inputpage
    }
  ]
})
