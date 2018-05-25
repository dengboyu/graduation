<template>
    <div id="app">
        <router-view/>
    </div>
</template>

<script>

    export default {
        name: 'app',
        components:{

        }
    }
</script>

<style>
    #app{
        background:#eae7ec;
        position: absolute;
        top:0px;
        bottom: 0px;
        width:100%;
        color:#4f564f;
        overflow: overlay;
    }
</style>
