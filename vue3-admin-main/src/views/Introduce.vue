<template>
 <div>欢迎进入！</div>

</template>

<script>
export default {
  name: 'Introduce',
  setup() {
    const goJuejin = () => {
      console.log('goJuejin')
      window.open('https://juejin.cn/book/6933939264455442444', 'target')
    }

    return {
      goJuejin
    }
  }
}
</script>
<style scoped>
  .course {
    font-weight: bold;
    display: inline-block;
  }
  .course li {
    line-height: 36px;
    color: #409eff;
    cursor: pointer;
  }
</style>