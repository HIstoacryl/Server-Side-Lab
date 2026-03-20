package com.lanhai.controller;

import com.lanhai.common.Result;
import com.lanhai.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户RESTful接口控制器
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    // 模拟内存数据库，存储用户数据
    private static final List<User> userList = new ArrayList<>();

    /**
     * 查询所有用户
     * @return 用户列表
     */
    @GetMapping
    public Result<List<User>> findAll() {
        return Result.success(userList);
    }

    /**
     * 根据ID查询单个用户
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Integer id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return Result.success(user);
            }
        }
        // 用户不存在，抛出异常，由全局异常处理器处理
        throw new RuntimeException("用户ID不存在：" + id);
    }

    /**
     * 新增用户
     * @param user 用户信息（JSON请求体）
     * @return 操作结果
     */
    @PostMapping
    public Result<String> add(@RequestBody User user) {
        userList.add(user);
        return Result.success("新增用户成功");
    }

    /**
     * 修改用户信息
     * @param id 用户ID
     * @param user 新的用户信息（JSON请求体）
     * @return 操作结果
     */
    @PutMapping("/{id}")
    public Result<String> update(@PathVariable Integer id, @RequestBody User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.set(i, user);
                return Result.success("修改用户成功");
            }
        }
        throw new RuntimeException("用户不存在，修改失败");
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Integer id) {
        boolean removeResult = userList.removeIf(user -> user.getId().equals(id));
        if (removeResult) {
            return Result.success("删除用户成功");
        }
        throw new RuntimeException("用户不存在，删除失败");
    }
}