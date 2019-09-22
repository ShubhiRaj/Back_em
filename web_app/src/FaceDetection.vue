<template>
  <div id="facedetection">
    <!-- <p>"Testing facedetection"</p> -->
  </div>
</template>

<script>
    import axios from 'axios';

    export default {
      name: 'facedetection',
      data () {
        return {
          msg: 'Welcome to facedetection'
        }
      }
      // ,
      // mounted() {
      //   axios
      //     .post('https://canadacentral.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&recognitionModel=recognition_01&returnRecognitionModel=false&detectionModel=detection_01', {
              
      //               'url': 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Leonardo_DiCaprio_January_2014.jpg/170px-Leonardo_DiCaprio_January_2014.jpg'
              
      //       },{
      //           headers:{
      //               'Ocp-Apim-Subscription-Key':'6387bed598264107aeb7b956692bee3a',
      //               'Content-Type':'application/json',
      //               'Host': 'canadacentral.api.cognitive.microsoft.com'
      //         }
      //       })
      //     .then(response => console.log(response))
      // }
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






