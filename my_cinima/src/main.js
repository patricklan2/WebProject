import Vue from 'vue'
import App from './App.vue'

//router
import router from './router';

// element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
Vue.use(ElementUI)

Vue.config.productionTip = false



router.beforeEach((to, from, next) => {
  console.log(to.path);
  if(to.path == '/login'){
    next();
  }else if(to.path.substring(0,6) == '/index' && localStorage.getItem('managerId')){
      next();
  }else if(to.path.substring(0,11) == '/memberView' && localStorage.getItem('memberId')){
      next();
  }else
    next('/login');
  }
);

 

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
