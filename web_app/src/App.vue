@charset "UTF-8";
<template>
  <div id="app">
    <img src="./assets/logo3.png">
    <h1>{{ msg }}</h1>
    <h2>Begin Registration</h2>
    <ul>
      <p>Full Name: {{ message }}</p>
      <input v-model="message" placeholder="Enter Name">

      <p>Image URL: {{ message }}</p>
      <input v-model="message" placeholder="Enter URL">
      <!-- <li><a href="https://vuejs.org" target="_blank">Core Docs</a></li> -->
      <!-- <li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li> -->
      <!-- <li><a href="https://chat.vuejs.org" target="_blank">Community Chat</a></li> -->
      <!-- <li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li> -->
    </ul>
    <my-button>Register</my-button>
    <h2>Receive Money</h2>
    <ul>
         
      <!-- <li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li> -->
      <!-- <li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li> -->
      <!-- <li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li> -->
      <!-- <li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li> -->
    </ul>
    
    <p>How Much Money Would You Like: {{ message }}</p>
    <input v-model="message" placeholder="Enter Amount">
    <my-button type="success">Receive Money</my-button>

  </div>


</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: "Welcome to Back'Em"
    }
  }
}

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}




.container {
  background-image: linear-gradient(-128deg, rgba(255, 181, 32, 0.93) 3%, rgba(239, 39, 153, 0.93) 88%, rgba(237, 18, 171, 0.93) 100%);
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
}


</style>

