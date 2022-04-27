import {createRouter, createWebHistory} from 'vue-router'
// import HomeView from '../views/Doctor.vue'
import Layout from '../layout/Layout.vue'
// import * as path from "path";
// 也可以import Login from '../views/Login.vue'

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/login",//重定向，什么都不加的时候自动跳转到home下
        children: [
            {
                path: 'doctor',
                name: 'Doctor',
                component: () => import("@/views/Doctor.vue")
            },
            {
                path: 'yuyue',
                name: 'Yuyue',
                component: () => import("@/views/Yuyue.vue")
            },
            {
                path: 'patient',
                name: 'Patient',
                component: () => import("@/views/Patient.vue")
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login.vue")
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("@/views/Register.vue")
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
