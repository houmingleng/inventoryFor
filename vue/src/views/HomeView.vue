<template>
  <div class="home">
      <div style="margin: 10px">
        <el-button type="primary" @click = "addItem">addItem</el-button>

      </div>

      <el-table :data="tableData" style="width: 80vh">
        <el-table-column prop="id" label="id"  />
        <el-table-column prop="name" label="name" />
        <el-table-column prop="address" label="address"  />
        <el-table-column prop="number" label="number"  />
        <el-table-column fixed="right" label="Operations" >
          <template #default="scope">
            <el-button text size="small" @click="handleShip(scope.row)" >ship</el-button>
            <el-button text size="small" @click="handleEdit(scope.row)">edit</el-button>
            <el-popconfirm title ="sure to delete?" @confirm="handleDelete(scope.row)">
              <template #reference>
                <el-button type="text">delete</el-button>
              </template>
            </el-popconfirm>

          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 15px 2px">
        <el-pagination
            v-model:currentPage="currentPage"
            v-model:page-size="pageSize4"
            :page-sizes="[10, 50, 100, 200]"
            :small="small"
            :disabled="disabled"
            :background="background"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
        />



  </div>

    <el-dialog v-model="dialogFormVisible" title="Shipping address">
      <el-form :model="form">
        <el-form-item label="name" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="address" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off" />
        </el-form-item>
        <el-form-item label="number" :label-width="formLabelWidth" type="number">
          <el-input v-model="form.number"  autocomplete="off"  oninput="if(value.length>8)value=value.slice(0,8);value=value.replace(/[^\d]/g,'')"/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="saveItem">Confirm</el-button
        >
      </span>
      </template>
    </el-dialog>
  </div>

</template>
<script>


import axios from "axios";
import request from "@/utils/request"

export default {
  name: 'HomeView',
  components: {
    // HelloWorld

  },data(){
    return{
      form:{
      },
      storage:{

      },
      dialogFormVisible : false,
      currentPage :1,
      total:10,
      tableData:[
            ],

      }

  },
  created() {
    load()
        let str = sessionStorage.getItem("item")
        if(str){
          this.storages = JSON.parse(str);
        request.put("/api/items", this.storages).then(res=>{
          console.log(res)
          this.storage = {}
        })
      }
      sessionStorage.clear()

    },
  methods:{
    load(){
      request.get("/api/items").then(res =>{
        console.log(res)
        this.tableData = res;
      })
    },
    addItem(){
      this.dialogFormVisible = true;

    this.form = {}
    },
    handleDelete(row){
      console.log(this.form)
      // debugger
        request.delete("/api/items/"+ row.id)

    },
    handleShip(row){
      sessionStorage.setItem("item",JSON.stringify(row));
      // var arr = JSON.stringify((row));
      // this.$router.push("/shipment"+ encodeURIComponent(arr))
      this.$router.push("/shipment")
    }
    ,
    saveItem(){

      if(this.form.id ){
        console.log(this.form)
        request.put("/api/items", this.form).then(res=>{
          console.log(res)
        })

      }else{
        request.post("/api/items", this.form).then(res=>{
          console.log(res)

        })

      }
      this.dialogFormVisible = false
      this.load();

    },
    handleEdit (row) {
      console.log(this.form.id)
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogFormVisible = true;
    },
    handleSizeChange(){

    },handleCurrentChange(){

    }

  }
  }

</script>
