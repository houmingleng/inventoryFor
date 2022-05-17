<template>
      <el-menu
          default-active="2"
          class="el-menu-vertical-demo">
<!--          @open="handleOpen"-->
<!--          @close="handleClose"-->
<!--      >-->
        <el-menu-item index="2">
          <el-icon><icon-menu /></el-icon>
          <span>Navigator One</span>
        </el-menu-item>
        <el-menu-item index="2">
          <el-icon><icon-menu /></el-icon>
          <span>Navigator Two</span>
        </el-menu-item>
        <el-menu-item index="4">
          <el-icon><setting /></el-icon>
          <span>Navigator Four</span>
        </el-menu-item>
      </el-menu>
</template>

<script>
export default {
  name: "SidePart"
}
</script>

<style scoped>

</style>