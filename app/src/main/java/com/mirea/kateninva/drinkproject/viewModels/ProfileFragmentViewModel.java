package com.mirea.kateninva.drinkproject.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mirea.kateninva.data.firebase.AuthController;
import com.mirea.kateninva.data.firebase.FirebaseAuthController;
import com.mirea.kateninva.data.repository.AuthRepositoryImpl;
import com.mirea.kateninva.domain.UserCallback;
import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.usecases.GetActiveUserIdUseCase;
import com.mirea.kateninva.domain.usecases.GetUserInfoUseCase;

public class ProfileFragmentViewModel extends ViewModel {

    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    private GetUserInfoUseCase getUserInfoUseCase;
    private GetActiveUserIdUseCase getActiveUserIdUseCase;

    public MutableLiveData<User> getUserLiveData() {
        return userLiveData;
    }

    public void setUserLiveData(User user) {
        userLiveData.setValue(user);
    }

    public ProfileFragmentViewModel() {
        AuthController authController = new FirebaseAuthController();
        AuthRepositoryImpl authRepository = new AuthRepositoryImpl(authController);

        getUserInfoUseCase = new GetUserInfoUseCase(authRepository);
        getActiveUserIdUseCase = new GetActiveUserIdUseCase(authRepository);
    }

    public void getUserInfo(UserCallback response) {
        getUserInfoUseCase.execute(getActiveUserIdUseCase.execute(), response);
    }

}
