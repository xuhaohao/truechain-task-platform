import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
const adminList = r => require.ensure([], () => r(require('@/page/adminList')), 'adminList');
const roleList = r => require.ensure([], () => r(require('@/page/roleList')), 'roleList');
const resourceList = r => require.ensure([], () => r(require('@/page/resourceList')), 'resourceList');

const routes = [{
        path: '/',
        component: login
    },
    {
        path: '/manage',
        component: manage,
        name: '',
        children: [{
            path: '',
            component: home,
            meta: [],
        }, {
            path: '/adminList',
            component: adminList,
            meta: ['设置', '管理员列表'],
        }, {
            path: '/roleList',
            component: roleList,
            meta: ['设置', '角色列表'],
        }, {
            path: '/resourceList',
            component: resourceList,
            meta: ['设置', '资源列表'],
        }]
    }
]

export default new Router({
    routes,
    strict: process.env.NODE_ENV !== 'production',
})
