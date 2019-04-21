import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Navigation from '@/components/footer/Navigation'
import Personal from '@/components/Personal'
import ShopList from '@/components/ShopList'
import ShopItem from '@/components/shop/ShopItem'
import FoodItem from '@/components/food/FoodItem'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/person',
      name: 'Personal',
      component: Personal
    },
    {
      path: '/shop',
      name: 'Shop',
      component: ShopItem
    },
    {
      path: '/food',
      name: 'Food',
      component: FoodItem
    }
  ]
})
