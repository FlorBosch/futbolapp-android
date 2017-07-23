package ar.com.futbolapp.ui;


public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}