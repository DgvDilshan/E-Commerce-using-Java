<nav>
  <div class="container">
    <div class="nav-wrapper">
      <div class="logo-wrapper">
        <button
          class="mobile-nav-toggle"
          id="mobile-nav-toggle"
          onclick="openMobileNav()"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
          >
            <path
              d="M7 8H17M7 12H17M7 16H17"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linecap="round"
            />
            <path
              d="M7 8H17M7 12H17M7 16H17"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linecap="round"
            />
          </svg>
        </button>
        <img src="assets/logo.png" alt="logo" />
      </div>

      <ul class="nav-list" role="list">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="">Shop</a></li>
        <li><a href="">Contact us</a></li>
      </ul>

      <div class="nav-icons">
        <button class="search-button" onclick="toggleSearch()">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
          >
            <path
              d="M18.5 18.5L22 22M21 11.5C21 6.25329 16.7467 2 11.5 2C6.25329 2 2 6.25329 2 11.5C2 16.7467 6.25329 21 11.5 21C16.7467 21 21 16.7467 21 11.5Z"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M18.5 18.5L22 22M21 11.5C21 6.25329 16.7467 2 11.5 2C6.25329 2 2 6.25329 2 11.5C2 16.7467 6.25329 21 11.5 21C16.7467 21 21 16.7467 21 11.5Z"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </button>
        <button class="profile-button" onclick="toggleProfileDropdown()">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
          >
            <path
              d="M18.5588 19.5488C17.5654 16.8918 15.0036 15 12 15C8.99638 15 6.4346 16.8918 5.44117 19.5488M18.5588 19.5488C20.6672 17.7154 22 15.0134 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 15.0134 3.33285 17.7154 5.44117 19.5488M18.5588 19.5488C16.8031 21.0756 14.5095 22 12 22C9.49052 22 7.19694 21.0756 5.44117 19.5488M15 9C15 10.6569 13.6569 12 12 12C10.3431 12 9 10.6569 9 9C9 7.34315 10.3431 6 12 6C13.6569 6 15 7.34315 15 9Z"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linejoin="round"
            />
            <path
              d="M18.5588 19.5488C17.5654 16.8918 15.0036 15 12 15C8.99638 15 6.4346 16.8918 5.44117 19.5488M18.5588 19.5488C20.6672 17.7154 22 15.0134 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 15.0134 3.33285 17.7154 5.44117 19.5488M18.5588 19.5488C16.8031 21.0756 14.5095 22 12 22C9.49052 22 7.19694 21.0756 5.44117 19.5488M15 9C15 10.6569 13.6569 12 12 12C10.3431 12 9 10.6569 9 9C9 7.34315 10.3431 6 12 6C13.6569 6 15 7.34315 15 9Z"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linejoin="round"
            />
          </svg>

          <div class="profile-dropdown" id="profile-dropdown">
            <ul class="list" role="list">
              <li><a href="sign-up">Sign up</a></li>
              <li><a href="sign-in">Sign in</a></li>
            </ul>
          </div>
        </button>
        <button class="cart-button">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
          >
            <path
              d="M9 6L9 7C9 8.65685 10.3431 10 12 10C13.6569 10 15 8.65685 15 7V6"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M9 6L9 7C9 8.65685 10.3431 10 12 10C13.6569 10 15 8.65685 15 7V6"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M15.6113 3H8.38836C6.433 3 4.76424 4.41365 4.44278 6.3424L2.77612 16.3424C2.36976 18.7805 4.24994 21 6.72169 21H17.278C19.7498 21 21.6299 18.7805 21.2236 16.3424L19.5569 6.3424C19.2355 4.41365 17.5667 3 15.6113 3Z"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linejoin="round"
            />
            <path
              d="M15.6113 3H8.38836C6.433 3 4.76424 4.41365 4.44278 6.3424L2.77612 16.3424C2.36976 18.7805 4.24994 21 6.72169 21H17.278C19.7498 21 21.6299 18.7805 21.2236 16.3424L19.5569 6.3424C19.2355 4.41365 17.5667 3 15.6113 3Z"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linejoin="round"
            />
          </svg>
          <span>2</span>
        </button>
      </div>
    </div>
  </div>

  <div class="mobile-nav" id="mobile-nav">
    <div class="mobile-nav-top">
      <div class="top-wrapper">
        <div>
          <img src="assets/logo.png" />
        </div>

        <button onclick="closeMobileNav()">
          <img src="assets/icons/close.png" />
        </button>
      </div>

      <div class="search">
        <div>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
          >
            <path
              d="M18.5 18.5L22 22M21 11.5C21 6.25329 16.7467 2 11.5 2C6.25329 2 2 6.25329 2 11.5C2 16.7467 6.25329 21 11.5 21C16.7467 21 21 16.7467 21 11.5Z"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M18.5 18.5L22 22M21 11.5C21 6.25329 16.7467 2 11.5 2C6.25329 2 2 6.25329 2 11.5C2 16.7467 6.25329 21 11.5 21C16.7467 21 21 16.7467 21 11.5Z"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </div>
        <input type="text" placeholder="Search" />
      </div>

      <ul class="mobile-nav-list" role="list">
        <li><a href="">Home</a></li>
        <li><a href="">Shop</a></li>
        <li><a href="">Contact us</a></li>
      </ul>
    </div>
    <div class="mobile-nav-bottom">
      <a href="" class="action-wrapper">
        <span> Cart </span>

        <div class="action-icon">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
          >
            <path
              d="M9 6L9 7C9 8.65685 10.3431 10 12 10C13.6569 10 15 8.65685 15 7V6"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M9 6L9 7C9 8.65685 10.3431 10 12 10C13.6569 10 15 8.65685 15 7V6"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M15.6113 3H8.38836C6.433 3 4.76424 4.41365 4.44278 6.3424L2.77612 16.3424C2.36976 18.7805 4.24994 21 6.72169 21H17.278C19.7498 21 21.6299 18.7805 21.2236 16.3424L19.5569 6.3424C19.2355 4.41365 17.5667 3 15.6113 3Z"
              stroke="#141718"
              stroke-width="1.5"
              stroke-linejoin="round"
            />
            <path
              d="M15.6113 3H8.38836C6.433 3 4.76424 4.41365 4.44278 6.3424L2.77612 16.3424C2.36976 18.7805 4.24994 21 6.72169 21H17.278C19.7498 21 21.6299 18.7805 21.2236 16.3424L19.5569 6.3424C19.2355 4.41365 17.5667 3 15.6113 3Z"
              stroke="black"
              stroke-opacity="0.2"
              stroke-width="1.5"
              stroke-linejoin="round"
            />
          </svg>
          <span>2</span>
        </div>
      </a>

      <a href="" class="action-wrapper">
        <span> Wishlist </span>

        <div class="action-icon">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="25"
            viewBox="0 0 24 25"
            fill="none"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M12.6924 7.58369C12.3055 7.955 11.6945 7.955 11.3076 7.58369L10.6152 6.91923C9.80477 6.1415 8.70994 5.66663 7.5 5.66663C5.01472 5.66663 3 7.68134 3 10.1666C3 12.5493 4.28979 14.5167 6.15176 16.1332C8.01532 17.7511 10.2434 18.8241 11.5746 19.3717C11.853 19.4862 12.147 19.4862 12.4254 19.3717C13.7566 18.8241 15.9847 17.7511 17.8482 16.1332C19.7102 14.5167 21 12.5492 21 10.1666C21 7.68134 18.9853 5.66663 16.5 5.66663C15.2901 5.66663 14.1952 6.1415 13.3848 6.91923L12.6924 7.58369ZM12 5.4762C10.8321 4.35543 9.24649 3.66663 7.5 3.66663C3.91015 3.66663 1 6.57678 1 10.1666C1 16.5349 7.97034 20.0516 10.8138 21.2213C11.5796 21.5363 12.4204 21.5363 13.1862 21.2213C16.0297 20.0516 23 16.5349 23 10.1666C23 6.57678 20.0899 3.66663 16.5 3.66663C14.7535 3.66663 13.1679 4.35543 12 5.4762Z"
              fill="#141718"
            />
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M12.6924 7.58369C12.3055 7.955 11.6945 7.955 11.3076 7.58369L10.6152 6.91923C9.80477 6.1415 8.70994 5.66663 7.5 5.66663C5.01472 5.66663 3 7.68134 3 10.1666C3 12.5493 4.28979 14.5167 6.15176 16.1332C8.01532 17.7511 10.2434 18.8241 11.5746 19.3717C11.853 19.4862 12.147 19.4862 12.4254 19.3717C13.7566 18.8241 15.9847 17.7511 17.8482 16.1332C19.7102 14.5167 21 12.5492 21 10.1666C21 7.68134 18.9853 5.66663 16.5 5.66663C15.2901 5.66663 14.1952 6.1415 13.3848 6.91923L12.6924 7.58369ZM12 5.4762C10.8321 4.35543 9.24649 3.66663 7.5 3.66663C3.91015 3.66663 1 6.57678 1 10.1666C1 16.5349 7.97034 20.0516 10.8138 21.2213C11.5796 21.5363 12.4204 21.5363 13.1862 21.2213C16.0297 20.0516 23 16.5349 23 10.1666C23 6.57678 20.0899 3.66663 16.5 3.66663C14.7535 3.66663 13.1679 4.35543 12 5.4762Z"
              fill="black"
              fill-opacity="0.2"
            />
          </svg>
          <span>2</span>
        </div>
      </a>
      <a href="sign-in" style="width: 100%">
        <b:Button text="Sign In" rounded="false" outlined="false" />
      </a>
    </div>
  </div>
</nav>
