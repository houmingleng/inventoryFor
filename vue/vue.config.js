const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.exports={
  devServer:{
    port: 7777,
    proxy : {
      '/api':{
        target :"http://localhost:9090",
        changeOrigin:true,
        pathRewrite:{
          '^/api':''
        }
      }
    }
  }
}
