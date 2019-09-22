<template>
  <div id="faceverification">
    <p>"Testing faceverification"</p>
  </div>
</template>

<script>
    import axios from 'axios';

    export default {
      name: 'faceverification',
      data () {
        return {
          msg: 'Welcome to faceverification'
        }
      },
      mounted() {
        axios
          .post('https://canadacentral.api.cognitive.microsoft.com/face/v1.0/verify', {
            
               'faceId1': '3d8d1d1a-3cd5-4b3f-a56e-aca162ed490e',
               'faceId2': '5dcfb516-f1c8-4618-abf0-3650c085a537'
            
          },{
              headers:{
                  'Ocp-Apim-Subscription-Key':'6387bed598264107aeb7b956692bee3a',
                  'Content-Type':'application/json',
                  'Host': 'canadacentral.api.cognitive.microsoft.com'
            }
          })
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






