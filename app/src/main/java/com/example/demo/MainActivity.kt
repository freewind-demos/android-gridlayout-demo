package com.example.demo

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * GridLayout 示例程序
 *
 * 展示如何在 Android 中使用 GridLayout 进行网格布局
 * GridLayout 将容器划分为行和列，形成网格，子视图被放置在指定的单元格中
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建根布局 - 使用 ConstraintLayout
        val rootLayout = ConstraintLayout(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
        }

        // 创建 GridLayout 作为主要布局容器
        // 设置为 3 列
        val gridLayout = GridLayout(this).apply {
            columnCount = 3  // 设置列数为 3
            rowCount = 4      // 设置行数为 4
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
                topMargin = 16
                bottomMargin = 16
                leftMargin = 16
                rightMargin = 16
            }
            // 设置内边距
            setPadding(16, 16, 16, 16)
        }

        // 创建标题
        val titleText = TextView(this).apply {
            text = "GridLayout\n网格布局"
            textSize = 18f
        }

        // 将标题添加到 GridLayout，占据第 0 行第 0 列
        gridLayout.addView(titleText, GridLayout.LayoutParams().apply {
            rowSpec = GridLayout.spec(0, 1f)    // 占据第 0 行，权重 1
            columnSpec = GridLayout.spec(0, 1f)  // 占据第 0 列，权重 1
            setGravity(Gravity.CENTER)
            setMargins(8, 8, 8, 8)
        })

        // 创建数字按钮
        val buttons = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-")

        buttons.forEachIndexed { index, text ->
            val button = Button(this).apply {
                this.text = text
                textSize = 20f
            }

            // 计算行和列
            val row = (index + 1) / 3 + 1  // 从第 1 行开始（跳过标题行）
            val col = (index + 1) % 3

            gridLayout.addView(button, GridLayout.LayoutParams().apply {
                rowSpec = GridLayout.spec(row, 1f)
                columnSpec = GridLayout.spec(col, 1f)
                setGravity(android.view.Gravity.FILL)
                setMargins(4, 4, 4, 4)
            })
        }

        // 将 GridLayout 添加到根布局
        rootLayout.addView(gridLayout)

        // 设置内容视图
        setContentView(rootLayout)
    }
}
