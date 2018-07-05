<template>
<section>
	<!--工具条-->
  <head-top></head-top>
	<el-col :span="24" class="toolbar" style="padding: 20px 20px 10px 20px;">
		<el-form :inline="true" class="demo-form-inline">
			<el-form-item>
				<el-button  @click.native="addUser" v-if="addUsers">新增用户</el-button>
			</el-form-item>
			<el-form-item>
				<el-button @click.native.prevent="getAdmin()">
					刷新
				</el-button>
			</el-form-item>
		</el-form>
	</el-col>

	<!--列表-->
	<template>
			<div class="fillcontain">
        
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

            <!--按钮-->
            <el-table-column
					  :context="_self"
					  inline-template
					  width="300"
					  align="center"
					  label="操作">
					<div>
					  <el-button
						size="small"
						type="info"
						v-if="editUser"
						 @click="editUser(row)">
						编辑
					  </el-button>
					  <el-button
						size="small"
						type="danger"
						v-if='deleteUser'
						 @click="deleteUser(row)">
						删除
					  </el-button>
					</div>
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
	
  
</section>
</template>

<script>
import headTop from "../components/headTop";
import { adminList } from "@/api/getData";
export default {
  data() {
    return {
      addUsers: true,
      editUser: true,
      deleteUser: true,
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
      this.getAdmin();
    },
    async getAdmin() {
      try {
        const res = await adminList({
          pageIndex: this.currentPage,
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
    },
    addUser() {
      console.log("OK");
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
