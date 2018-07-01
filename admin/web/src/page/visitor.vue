<template>
    <section>
    <!--工具条-->
	<el-col :span="24" class="toolbar" style="padding: 20px 20px 10px 20px;">
		<el-form :inline="true" :model="formInlinemobile" ref="formInlinemobile" class="demo-form-inline">
			<el-form-item>
				<el-button @click="handleAdd">新增</el-button>
			</el-form-item>
		</el-form>
	</el-col>
    </section>
    <template>

    </template>
</template>

<template>
    <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 100%">
		      <el-table-column
		        prop="username"
		        label="账号"
		        width="180">
		      </el-table-column>
              <el-table-column
                prop="realName"
                label="姓名"
                width="220">
              </el-table-column>
              <el-table-column
		        prop="createTime"
		        label="注册日期"
		        width="180">
		      </el-table-column>
		      <el-table-column
		        prop="email"
		        label="邮箱">
		      </el-table-column>
		    </el-table>
		    <div class="Pagination" style="text-align: left;margin-top: 10px;">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="currentPage"
                  :page-size="20"
                  layout="total, prev, pager, next"
                  :total="count">
                </el-pagination>
            </div>
        </div>
    </div>
</template>



<script>
import headTop from "../components/headTop";
import { adminList } from "@/api/getData";
export default {
  data() {
    return {
      tableData: [],
      currentRow: null,
      offset: 0,
      limit: 20,
      count: 0,
      currentPage: 1
    };
  },
  components: {
    headTop
  },
  created() {
    this.getAdmin();
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.offset = (val - 1) * this.limit;
      this.getAdmin();
    },
    async getAdmin() {
      try {
        const res = await adminList({
          pageIndex: this.offset + 1,
          pageSize: this.limit
        });
        if (res.code == 200) {
          console.log(res);
          var result = res.result;
          this.tableData = [];
          result.content.forEach(item => {
            const tableItem = {
              username: item.username,
              realName: item.realName,
              createTime: item.createTime,
              email: item.email
            };
            this.tableData.push(tableItem);
            this.count = result.totalElements;
          });
        } else {
          throw new Error(res.message);
        }
      } catch (err) {
        console.log("获取数据失败", err);
      }
    }
  }
};
</script>

<style lang="less">
@import "../style/mixin";
.table_container {
  padding: 20px;
}
</style>


