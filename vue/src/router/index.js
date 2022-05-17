import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import layout from '../layout/layout.vue'
const routes = [
  {
    path: '/',
    name: 'layout',
    component: layout,
    redirect:"/home",
    children: [
      {
        path: '/home',
        name: 'HomeView',
        component : ()=> import("@/views/HomeView")
      },
      {
        path:'/shipment',
        name:'Shipment',
        component:()=>import("@/views/Shipment")
      }
    ]
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
