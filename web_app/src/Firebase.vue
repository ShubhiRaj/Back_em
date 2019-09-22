<template>
  <div id="firebase">
    <p>"Testing firebase"</p>
  </div>
</template>

<script>
    import axios from 'axios';

    export default {
      name: 'firebase',
      data () {
        return {
          msg: 'Welcome to Firebase'
        }
      },
      mounted() {
        axios
          .get('https://back-em.firebaseio.com/.json')
          .then(response => console.log(response))
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
</style>






