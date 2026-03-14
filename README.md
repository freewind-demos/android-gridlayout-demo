# android-gridlayout-demo

## 简介

本 demo 展示了如何在 Android 应用中使用 GridLayout 进行网格布局。GridLayout 将容器划分为行和列，形成网格结构，非常适合显示表格数据或计算器界面。

## 基本原理

GridLayout 将容器划分为等大小的单元格网格：

- **columnCount**：列数
- **rowCount**：行数
- **LayoutParams**：指定视图占据的行和列

GridLayout 中的子视图可以占据一个或多个单元格，通过 rowSpec 和 columnSpec 来指定。

## 启动和使用

### 环境要求
- Android Studio Arctic Fox 或更高版本
- JDK 11 或更高版本
- Android SDK 34

### 安装和运行
1. 使用 Android Studio 打开本项目
2. 连接 Android 设备或启动模拟器
3. 点击 Run 按钮运行应用

## 教程

### 什么是 GridLayout？

GridLayout 是 Android 中用于创建网格布局的组件。它将容器划分为行和列，形成网格，子视图被放置在指定的单元格中。

### 核心概念

1. **单元格（Cell）**：网格中的最小单位
2. **rowSpec**：定义视图占据的行
3. **columnSpec**：定义视图占据的列

### 使用示例

1. 基础用法：
```kotlin
val gridLayout = GridLayout(this).apply {
    columnCount = 3  // 3 列
    rowCount = 4     // 4 行
}

// 添加按钮到指定位置
gridLayout.addView(button, GridLayout.LayoutParams().apply {
    rowSpec = GridLayout.spec(0, 1f)    // 第 0 行
    columnSpec = GridLayout.spec(0, 1f)  // 第 0 列
})
```

2. 使用权重：
```kotlin
// 权重为 1f 表示占据一个单位
rowSpec = GridLayout.spec(row, 1f)
columnSpec = GridLayout.spec(col, 1f)
```

3. 跨越多行/多列：
```kotlin
// 占据 2 行 2 列
rowSpec = GridLayout.spec(row, 2)
columnSpec = GridLayout.spec(col, 2)
```

### 常用属性

| 属性 | 说明 |
|------|------|
| `columnCount` | 列数 |
| `rowCount` | 行数 |
| `alignmentMode` | 对齐模式 |
| `useDefaultMargins` | 使用默认边距 |

### 注意事项

1. **等大小单元格**：GridLayout 默认所有单元格大小相同
2. **自动扩展**：可以只设置 columnCount 或 rowCount，另一个会自动计算
3. **顺序**：默认按照添加顺序从左到右、从上到下排列
4. **计算器示例**：非常适合实现计算器键盘布局
