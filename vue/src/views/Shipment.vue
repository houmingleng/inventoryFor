<!--<template>-->
<!--  <div style="width: 100% ;height:100%; background_color:lightblue; overflow: hidden">-->
<!--    <div style="width: 450px ; margin: 150px auto">-->
<!--      <el-form :model="form" status-icon :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">-->
<!--        <el-form-item label="ship_address" prop="ship_address">-->
<!--          <el-input  v-model="form.address" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="this.storages.number" prop="number">-->
<!--          <el-input type="number" v-model="form.number" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="name" prop="name">-->
<!--          <el-input v-model="storages.name"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-button type="primary" @click="submitForm('form')">Submit</el-button>-->
<!--          <el-button @click="resetForm('ruleForm')">Reset</el-button>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--    </div>-->

<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--import request from "@/utils/request"-->

<!--export default {-->
<!--  name:"Shipment",-->
<!--  data(){-->
<!--    return {-->
<!--      form:{},-->
<!--      storages:{}-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    let str = sessionStorage.getItem("item")-->
<!--    this.storages = JSON.parse(str);-->
<!--  },-->
<!--  methods:{-->
<!--    submitForm(form){-->
<!--      if(this.storages.number > form.number){-->
<!--        request.post("api/shipment",this.form).then(res=>{-->
<!--          console.log(res)-->
<!--          this.storages.number = this.storages.number - form.number;-->

<!--        })-->
<!--      }else{-->

<!--      }-->
<!--    }-->
<!--  }-->
<!--}-->

<!--</script>-->
<!--<style scoped>-->

<!--</style>-->
<template>
  <router-link :to="{name: 'HomeView'}" tag="button">Go to home</router-link>

  <div style="width: 100% ;height:100%; background_color:lightblue; overflow: hidden">
    <div style="width: 450px ; margin: 150px auto">
      <div style="color:white; font-size: 30px; text-align: center">welcome to shipment</div>
      <el-form ref="form" :model="form">
<!--        <el-form-item label= v-model="form.address" v-model="form.address "></el-form-item>-->
        <el-form-item label= "name" v-model="form.name ">{{this.storages.name}} </el-form-item>
        <el-form-item label="address">
          <el-input v-model="form.address" size=""></el-input>
        </el-form-item>
        <el-form-item label="number" type="number">stock still have {{this.storages.number}}
          <el-input id = "number" v-model="form.number" type="number" ></el-input>
        </el-form-item>

        <el-button text size="large" @click="handleShip()">Ship</el-button>

      </el-form>
    </div>

  </div>

</template>

<script>
import request from "@/utils/request"
export default {
  props: ['chartData'],
  name:"Shipment",
  data(){
    // console.log(this.$route.params)
    return {
      form: {},
      storages:{},

    }
  },
  created() {
    let str = sessionStorage.getItem("item")
    if(str){
      this.storages = JSON.parse(str);

    }
  },
  methods:{
    handleShip() {

      this.form.name = this.storages.name;
      if(this.storages.number >= this.form.number &&this.form.number>=0 ){

          request.post("/api/shipment", this.form).then(res=>{

            this.storages.number -=  this.form.number;
            console.log(this.storages.number)
            sessionStorage.clear();
            sessionStorage.setItem("item",JSON.stringify(this.storages));

            alert("succuess")
            this.$router.push("/")
          })
      }else{
        alert("amount not allowed")
      }
    }
  }
}

</script>

