package com.nammaskill.app.ui.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammaskill.app.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileToEditProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profile_to_editProfile)
  }
}
