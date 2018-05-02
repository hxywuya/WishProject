package com.example.xiaoyihaung.wish

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xiaoyihaung.wish.adapter.WishAdapter
import com.example.xiaoyihaung.wish.model.WishModel
import com.example.xiaoyihaung.wish.model.WishModel.Wish
import com.example.xiaoyihaung.wish.util.CommonUtil
import com.example.xiaoyihaung.wish.util.GridSpacingItemDecoration


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    private var refreshListener: SwipeRefreshLayout.OnRefreshListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)
        // 初始化列表
        val wishListView: RecyclerView = view.findViewById(R.id.wish_list)
        wishListView.layoutManager = LinearLayoutManager(context)
        wishListView.addItemDecoration(GridSpacingItemDecoration(1, CommonUtil.dp2px(context, 12f), true))
        var wishModel = WishModel()
        val wishList = wishModel.getWishList()
        val wishAdapter = WishAdapter(wishList as MutableList<Wish>)
        wishListView.adapter = wishAdapter
        // 注册加载事件
        val refreshLayout = view.findViewById(R.id.refresh_layput) as SwipeRefreshLayout
        refreshListener = SwipeRefreshLayout.OnRefreshListener {
            val apiServer = APIServer()
            apiServer.getWishList(object: APIServer.Callback<Wish>{
                override fun onSuccess(data: List<Wish>) {
                    Log.d("APIServer", "从API获取的:" + data[0].content + " Size:" + data.size)
                    refreshLayout.isRefreshing = false
                    val act = context as Activity
                    act.runOnUiThread {
                        wishAdapter.add(0, data)
                    }
                    // 将获取到的数据保存到数据库
                    for (wish in data) {
                        wishModel.saveData(wish)
                    }

                }

                override fun onFail(msg: String) {
                    refreshLayout.isRefreshing = false
                }
            })
        }
        refreshLayout.setOnRefreshListener(refreshListener)
        // 如果首次获取的数据为0 则从API加载
        if (wishList.isEmpty()) {
            refreshLayout.isRefreshing = true
            refreshListener!!.onRefresh()
        }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
//            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
