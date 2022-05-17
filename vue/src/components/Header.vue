<template>
  <div style="height: 60px; line-height:60px;border-bottom:2px solid black ; display: flex"></div>

  <div style="flex: 1"></div>
  <div style="width: 100px">

    <el-dropdown>
      <el-button type="primary">
        Houming(alan) Leng<el-icon class="el-icon--right"><arrow-down /></el-icon>
      </el-button>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item>personality</el-dropdown-item>
          <el-dropdown-item>story</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

</style>