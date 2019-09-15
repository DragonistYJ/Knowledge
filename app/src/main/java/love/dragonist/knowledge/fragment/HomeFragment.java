package love.dragonist.knowledge.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

import love.dragonist.knowledge.loader.SlideImageLoader;
import love.dragonist.knowledge.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Banner banner;
    private RelativeLayout relChinese;
    private RelativeLayout relMath;
    private RelativeLayout relEnglish;
    private RelativeLayout relChemistry;
    private RelativeLayout relPhysics;
    private RelativeLayout relBiology;
    private RelativeLayout relPolitics;
    private RelativeLayout relHistory;
    private RelativeLayout relGeography;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //轮播台配置
        banner = view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CENTER);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new SlideImageLoader());
        ArrayList<String> images = new ArrayList<>();
        images.add("https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=83bd0dcc8db1cb132a643441bc3d3d2b/a8773912b31bb0514f0cd50b367adab44aede0ed.jpg");
        images.add("https://img-blog.csdn.net/20160127144328827?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center");
        banner.setImages(images);
        banner.start();

        //跳转到单个学科的页面
        relChinese = view.findViewById(R.id.chinese);
        relChinese.setOnClickListener(new ProjectClickListen("语文"));
        relMath = view.findViewById(R.id.math);
        relMath.setOnClickListener(new ProjectClickListen("数学"));
        relEnglish = view.findViewById(R.id.english);
        relEnglish.setOnClickListener(new ProjectClickListen("英语"));
        relChemistry = view.findViewById(R.id.chemistry);
        relChemistry.setOnClickListener(new ProjectClickListen("化学"));
        relPhysics = view.findViewById(R.id.physics);
        relPhysics.setOnClickListener(new ProjectClickListen("物理"));
        relBiology = view.findViewById(R.id.biology);
        relBiology.setOnClickListener(new ProjectClickListen("生物"));
        relPolitics = view.findViewById(R.id.politics);
        relPolitics.setOnClickListener(new ProjectClickListen("政治"));
        relHistory = view.findViewById(R.id.history);
        relHistory.setOnClickListener(new ProjectClickListen("历史"));
        relGeography = view.findViewById(R.id.geography);
        relGeography.setOnClickListener(new ProjectClickListen("地理"));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    class ProjectClickListen implements View.OnClickListener {
        private String project;

        public ProjectClickListen(String project) {
            this.project = project;
        }

        @Override
        public void onClick(View v) {
            mListener.onFragmentInteraction(Uri.parse(project));
        }
    }
}
