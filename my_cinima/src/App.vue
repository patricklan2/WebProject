<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
export default {
   name: 'App'
}
</script>

<style>
/* @import "./assets/css/main.css"; */
/* @import "./assets/css/color-dark.css"; */

* {
    margin: 0;
    padding: 0;
}

.table {
    width: 100%;
    font-size: 14px;
}

html, body, #app, .wrapper {
  width: 100%;
  height: 100%;
  overflow: hidden;
}

body {
  font-family: 'PingFang SC', "Helvetica Neue", Helvetica, "microsoft yahei", arial, STHeiTi, sans-serif;
}

.pagination {
    margin: 20px 0;
    text-align: right;
}
</style>
