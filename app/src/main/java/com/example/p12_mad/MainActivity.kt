package com.example.p12_mad

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Response
import java.net.URL
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    val listitems = Contact.contactArray as ArrayList<Contact>
    val adapter = contactsAdapter(this, listitems)
    lateinit var list: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()




            list = findViewById(R.id.listView)
            val arr = listitems
            list.setOnItemClickListener { parent, view, position, id ->
                val name: String = arr[position].name.toString()
                val num: String = arr[position].num.toString()
                val addr: String = arr[position].addr
                val id:String = arr[position]._id.toString()

                val intent = Intent(this, ContactDetails::class.java)
                intent.putExtra("_id",id)
                intent.putExtra("name", name)
                intent.putExtra("num", num)
                intent.putExtra("addr", addr)
                startActivity(intent)

            }
            contacts().execute()


        }

        inner class contacts() : AsyncTask<String, Void, String>() {
            override fun onPreExecute() {
                super.onPreExecute()

            }

            override fun doInBackground(vararg params: String?): String? {
                var response: String?
                try {
                    response =
                        URL("https://api.json-generator.com/templates/9saPfEmt_cuM/data?access_token=yto1xyaoosmpd77r0lneapvsmeznilky46dpq6mo").readText(
                            Charsets.UTF_8
                        )

                } catch (e: Exception) {
                    response = null
                }
                return response
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                try {

                    /* Extracting JSON returns from the API */
                    val jsonarr = JSONArray(result)

                    for (i in 0..12) {

                        val jsonObj_0 = jsonarr.getJSONObject(i)
                        val id_jason = "Person ID : " + jsonObj_0.getString("_id")
                        val name_json = "Name : " + jsonObj_0.getString("name")
                        val num_json = "Phone No : " + jsonObj_0.getString("phone")
                        val add_json = "Address : " + jsonObj_0.getString("address")
                        listitems.add(Contact(id_jason, name_json, num_json, add_json))
                        list.adapter = adapter
                    }


                } catch (e: Exception) {


                }

            }
        }

    }
