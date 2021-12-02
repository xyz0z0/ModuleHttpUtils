package xyz.xyz0z0.modulehttputil

import android.os.Bundle
import android.util.ArrayMap
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ThreadUtils
import okhttp3.ResponseBody
import xyz.xyz0z0.httputil.HttpUtils
import xyz.xyz0z0.httputil.Transform
import xyz.xyz0z0.httputil.toFormBody


class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var btnGetBanner: Button
    private lateinit var btnGetUnread: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HttpInitUtils.init(this)



        findView()

        val netCallBack1: Transform = object : Transform {


            override fun transformResponse(responseBody: ResponseBody): String {
                return responseBody.string()
            }
        }
        HttpUtils.registerHost(Constants.baseUrl, netCallBack1)




        btnLogin.setOnClickListener {
            ThreadUtils.executeByIo(object : ThreadUtils.SimpleTask<Boolean>() {
                override fun doInBackground(): Boolean {
                    val map = ArrayMap<String, String>()
                    map["username"] = CustomConstants.USERNAME
                    map["password"] = CustomConstants.PASSWORD
                    val result = HttpUtils.with().url(Constants.loginUrl).post(map.toFormBody())
                    LogUtils.json(result)
                    return false
                }

                override fun onSuccess(result: Boolean) {

                }

            })

        }

        btnGetBanner.setOnClickListener {


        }

        btnGetUnread.setOnClickListener {
            Thread(Runnable {
                val result = HttpUtils.with().url(Constants.unreadCountUrl).get(emptyMap())
                LogUtils.json("ccc", result)
            }).start()

        }

    }

    private fun findView() {
        btnLogin = findViewById(R.id.btnLogin)
        btnGetBanner = findViewById(R.id.btnGetBanner)
        btnGetUnread = findViewById(R.id.btnGetUnread)
    }


}