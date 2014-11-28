package in.srain.cube.views.ptr.demo.ui.storehouse;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import in.srain.cube.image.CubeImageView;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.mints.base.TitleBaseFragment;
import in.srain.cube.util.Debug;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrStoreHouseHeaderFrameLayout;
import in.srain.cube.views.ptr.demo.R;

public class ETaoFragment extends TitleBaseFragment {

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_storehouse_etao, null);

        setHeaderTitle("Storehouse");

        Resources res = getResources();
        res.getStringArray(R.array.akta);

        CubeImageView imageView = (CubeImageView) view.findViewById(R.id.store_house_ptr_image);
        ImageLoader imageLoader = ImageLoaderFactory.create(getContext());
        String pic = "http://img5.duitang.com/uploads/item/201406/28/20140628122218_fLQyP.thumb.jpeg";
        imageView.loadImage(imageLoader, pic);

        Debug.DEBUG_PTR_FRAME = true;

        final PtrStoreHouseHeaderFrameLayout frame = (PtrStoreHouseHeaderFrameLayout) view.findViewById(R.id.store_house_ptr_frame);
        // frame.getHeader().initWithStringArray(R.array.storehouse);
        frame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frame.refreshComplete();
                    }
                }, 3000);
            }
        });
        return view;
    }
}