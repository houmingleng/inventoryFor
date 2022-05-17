<template>
  <div>
    <Header/>
    <!--      bodypart-->
    <div style="display: flex">

      <SidePart/>

      <router-view />
    </div>
  </div>

</template>
<script>

import Header from "@/components/Header";
import SidePart from "@/components/SidePart";
export default {
  name:"layout",
  components:{
    Header,
    SidePart
  }
}

</script>
