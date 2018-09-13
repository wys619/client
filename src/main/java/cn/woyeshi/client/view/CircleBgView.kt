package cn.woyeshi.client.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import cn.woyeshi.client.R


class CircleBgView : View {

    private var bgPaint: Paint? = null
    private var circlePaint: Paint? = null
    private var startColor: Int = 0
    private var endColor: Int = 0
    private var circleColor: Int = 0
    private var interval: Int = 0
    private var circleWidth: Int = 0
    private var centerX = 0
    private var centerY = 0

    private var mWidth = 0
    private var mHeight = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val arrays = context.obtainStyledAttributes(attrs, R.styleable.CircleBgView)
        startColor = arrays.getColor(R.styleable.CircleBgView_startColor, Color.RED)
        endColor = arrays.getColor(R.styleable.CircleBgView_endColor, Color.YELLOW)
        circleColor = arrays.getColor(R.styleable.CircleBgView_circleColor, Color.GRAY)
        interval = arrays.getDimensionPixelSize(R.styleable.CircleBgView_interval, 100)

        circleWidth = arrays.getDimensionPixelSize(R.styleable.CircleBgView_circleWidth, 5)
        centerX = arrays.getDimensionPixelSize(R.styleable.CircleBgView_centerX, 100)
        centerY = arrays.getDimensionPixelSize(R.styleable.CircleBgView_centerY, 100)
        arrays.recycle()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (bgPaint == null) {
            initBgPaint()
        }
        if (circlePaint == null) {
            initCirclePaint()
        }
        val maxRadius = if (mWidth - centerX < mWidth / 2) {
            mWidth - centerX + mWidth / 2
        } else {
            mWidth - centerX
        }
        canvas.drawCircle(mWidth / 2f, mHeight / 2f, mWidth.toFloat() * 2, bgPaint)
        var radius = interval * 4f
        while (true) {
            radius += interval
            if (radius > maxRadius) {
                break
            }
            canvas.drawCircle(mWidth / 2f, mHeight / 2f, radius, circlePaint)
        }
    }

    private fun initCirclePaint() {
        circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        circlePaint!!.style = Paint.Style.STROKE
        circlePaint!!.strokeWidth = circleWidth.toFloat()
        circlePaint!!.color = circleColor
    }

    private fun initBgPaint() {
        bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        bgPaint!!.style = Paint.Style.FILL
        val gradient = RadialGradient(mWidth / 2f, mHeight / 2f, (if (mHeight > mWidth) mHeight / 2f else mWidth / 2f), startColor, endColor, Shader.TileMode.CLAMP)
        bgPaint!!.shader = gradient
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.i("abababa   ", "heightMeasureSpec ：$heightMeasureSpec")
        Log.i("abababa   ", "widthMeasureSpec ：$widthMeasureSpec")
        mWidth = this.getMeasuredSize(widthMeasureSpec, true)
        mHeight = this.getMeasuredSize(heightMeasureSpec, false)
        setMeasuredDimension(mWidth, mHeight)
    }

    private fun getMeasuredSize(widthMeasureSpec: Int, b: Boolean): Int {
        //模式
        val specMode = View.MeasureSpec.getMode(widthMeasureSpec)
        //尺寸
        val specSize = View.MeasureSpec.getSize(widthMeasureSpec)
        //计算所得的实际尺寸，要被返回
        var retSize = 0
        //得到两侧的留边
        val padding = if (b) paddingLeft + paddingRight else paddingTop + paddingBottom
        Log.i("abababa   ", "specMode ：$specMode")
        Log.i("abababa   ", "specSize ：$specSize")
        Log.i("abababa   ", "padding ：$padding")
        Log.i("abababa   ", "MeasureSpec.EXACTLY ：" + View.MeasureSpec.EXACTLY)
        Log.i("abababa   ", "MeasureSpec.UNSPECIFIED ：" + View.MeasureSpec.UNSPECIFIED)
        Log.i("abababa   ", "MeasureSpec.AT_MOST ：" + View.MeasureSpec.AT_MOST)
        //对不同模式进行判断
        if (specMode == View.MeasureSpec.EXACTLY) {//显示指定控件大小
            retSize = specSize
            Log.i("abababa   ", "if")
        } else {
            Log.i("abababa   ", "retSize  后 ：  $retSize")
            if (specMode == View.MeasureSpec.UNSPECIFIED) {
                retSize = Math.min(retSize, specSize)
            }
        }
        return retSize
    }

}