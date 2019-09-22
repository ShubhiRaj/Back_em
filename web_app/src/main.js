import Vue from 'vue'
import App from './App.vue'
import Firebase from './Firebase'
import FaceDetection from './FaceDetection'
import FaceVerification from './FaceVerification'

new Vue({
  el: '#app',
  render: h => h(App)
})

new Vue({
  el: '#firebase',
  render: h => h(Firebase)
})

new Vue({
  el: '#facedetection',
  render: h => h(FaceDetection)
})

new Vue({
  el: '#faceverification',
  render: h => h(FaceVerification)
})