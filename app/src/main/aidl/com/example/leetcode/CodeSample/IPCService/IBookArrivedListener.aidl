// IBookArrivedListener.aidl
package com.example.leetcode.CodeSample.IPCService;

// Declare any non-default types here with import statements
import com.example.leetcode.CodeSample.IPCService.Book;

interface IBookArrivedListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onNewbook(in Book book);
}
