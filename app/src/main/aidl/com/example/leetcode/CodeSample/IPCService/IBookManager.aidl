// IBookManager.aidl
package com.example.leetcode.CodeSample.IPCService;

// Declare any non-default types here with import statements
import com.example.leetcode.CodeSample.IPCService.Book;
import com.example.leetcode.CodeSample.IPCService.IBookArrivedListener;


interface IBookManager {

    List<Book> getBookList();

        // AIDL 中除了基本数据类型，其他数据类型必须标上方向,in,out 或者 inout
        // in 表示输入型参数
        // out 表示输出型参数
        // inout 表示输入输出型参数

    void addBook(in Book book);

    void registerListener(IBookArrivedListener listener);
    void unregisterListener(IBookArrivedListener listener);
}
