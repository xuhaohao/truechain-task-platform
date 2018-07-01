import fetch from '@/config/fetch'

export const login = data => fetch('/unauth/account/login', data, 'POST', 'form'); //登陆
export const signout = () => fetch('/admin/user/exit'); //退出
export const adminList = data => fetch('/admin/user/getUserPage', data, 'POST', 'form'); //管理员列表
export const roleList = data => fetch('/admin/role/getRolePage', data, 'POST', 'form'); //角色列表
export const resourceList = data => fetch('/admin/resource/getResourcePage', data, 'POST', 'form'); //角色列表