@charset "UTF-8";
<template>
  <div id="app">
    <img class="logo" src="./assets/logo.png">
  <h1>{{ msg }}</h1>
  
  <form>
  

  <fieldset>
    <legend><span class="number">1</span>Begin Registration</legend>
    <label for="name">Full Name: {{ message }}</label>
    <input type="text" id="name" name="user_name" v-model="message" placeholder="Enter Name">

    <label for="img">Image URL:</label>
    <input type="text" id="img" name="user_img" v-model="message" placeholder="Enter URL">
  </fieldset>
 
  <button  v-on:click="register_api()">Register</button>

  </form>
  <form>
    <fieldset>
      <legend><span class="number">2</span> Recieve Money</legend>
      <label for="money">Name:</label>
      <input type="number" id="amount" name="user_amount" v-model="message" placeholder="Enter Name">
      <label for="money">Image URL:</label>
      <input type="number" id="amount" name="user_amount" v-model="message" placeholder="Enter Image">
      <label for="money">How much money would you like:</label>
      <input type="number" id="amount" name="user_amount" v-model="message" placeholder="Enter Amount">
    </fieldset>

    <button v-on:click="recieve_money()">Ready to go!</button>
  </form>
  </div>


</template>

<script>
    import axios from 'axios';
    var faceIdDetected = '';
export default {
  name: 'app',
  data () {
    return {
      msg: "Welcome to Back'Em"
    }
  },
  methods: {
    register_api(){
        // console.log("Here")
        // ,
        axios({
          method: "POST",
          "url":"https://canadacentral.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&recognitionModel=recognition_01&returnRecognitionModel=false&detectionModel=detection_01"
          , "data" :{
                    'url': 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Leonardo_DiCaprio_January_2014.jpg/170px-Leonardo_DiCaprio_January_2014.jpg'
          },
          "headers" :{
                    "Ocp-Apim-Subscription-Key":"6387bed598264107aeb7b956692bee3a",
                    "Content-Type":"application/json",
                    "Host": "canadacentral.api.cognitive.microsoft.com"
              }
          })
          .then(response => {
            var objectreturn = ((JSON.stringify(JSON.parse(JSON.stringify(response)).data)));
            faceIdDetected = JSON.parse(objectreturn.slice(1,objectreturn.length-1)).faceId;
            alert(faceIdDetected);
            axios({
            method: "PATCH",
            "url":"https://back-em.firebaseio.com/.json"
            , "data" :{
                      'Jake': {
                        'amount' : 0,
                        'faceId' : faceIdDetected,
                        'name' : 'Jake'
                      }
            }
            })
            .then(response => {
              alert("Yes");
              
            }
            , error=> {console.error(error);
            });
          }
          , error=> {console.error(error);
          });
          
        // alert("Testing");
      }
    },
    recieve_money(){
      // alert("YES");
      axios({
          method: "POST",
          "url":"https://canadacentral.api.cognitive.microsoft.com/face/v1.0/verify"
          , "data" :{
                    'faceId1': '3d8d1d1a-3cd5-4b3f-a56e-aca162ed490e',
               'faceId2': '5dcfb516-f1c8-4618-abf0-3650c085a537'
          },
          "headers" :{
                    "Ocp-Apim-Subscription-Key":"6387bed598264107aeb7b956692bee3a",
                    "Content-Type":"application/json",
                    "Host": "canadacentral.api.cognitive.microsoft.com"
              }
          })
          .then(response => {
            alert(response);
          }
          , error=> {console.error(error);
          });
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

*,
*:before,
*:after {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

body {
  font-family: 'Nunito', sans-serif;
  color: #384047;
}

form {
  max-width: 300px;
  margin: 10px auto;
  padding: 10px 20px;
  background: #f4f7f8;
  border-radius: 8px;
}

h1 {
  margin: 0 0 30px 0;
  text-align: center;
}

input[type="text"],
input[type="password"],
input[type="date"],
input[type="datetime"],
input[type="email"],
input[type="number"],
input[type="search"],
input[type="tel"],
input[type="time"],
input[type="url"],
textarea,
select {
  background: rgba(255, 255, 255, 0.1);
  border: none;
  font-size: 16px;
  height: auto;
  margin: 0;
  outline: 0;
  padding: 15px;
  width: 100%;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
  margin-bottom: 30px;
}

input[type="radio"],
input[type="checkbox"] {
  margin: 0 4px 8px 0;
}

select {
  padding: 6px;
  height: 32px;
  border-radius: 2px;
}

button {
  padding: 19px 39px 18px 39px;
  color: #FFF;
  background-color: #154854;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  border-radius: 5px;
  width: 100%;
  border: 1px solid#154854;
  border-width: 1px 1px 3px;
  box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.1) inset;
  margin-bottom: 10px;
}

fieldset {
  margin-bottom: 30px;
  border: none;
}

legend {
  font-size: 1.4em;
  margin-bottom: 10px;
}

label {
  text-align: left;
  display: block;
  margin-bottom: 8px;
}

label.light {
  font-weight: 300;
  display: inline;
}

.number {
  background-color:#154854;
  color: #fff;
  height: 30px;
  width: 30px;
  display: inline-block;
  font-size: 0.8em;
  margin-right: 4px;
  line-height: 30px;
  text-align: center;
  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.2);
  border-radius: 100%;
}
img{
  width:200px;;
}
@media screen and (min-width: 480px) {
  form {
    max-width: 480px;
  }
}


</style>

